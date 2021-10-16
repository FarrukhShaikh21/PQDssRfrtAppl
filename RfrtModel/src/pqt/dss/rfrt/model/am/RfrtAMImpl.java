package pqt.dss.rfrt.model.am;

import java.sql.SQLException;
import java.sql.Types;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import oracle.jbo.JboException;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.sql.NUMBER;

import oracle.jbo.domain.Number;

import oracle.jbo.server.DBTransaction;

import oracle.jdbc.internal.OracleCallableStatement;

import pqt.dss.rfrt.model.am.common.RfrtAM;
import pqt.dss.rfrt.model.vo.DssReqResigTermHeaderViewImpl;
import pqt.dss.rfrt.model.vo.DssReqResigTermHeaderViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jul 19 17:22:05 PKT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RfrtAMImpl extends ApplicationModuleImpl implements RfrtAM {
    /**
     * This is the default constructor (do not remove).
     */
    public RfrtAMImpl() {
    }

    /**
     * Container's getter for DssReqResigTermHeaderView1.
     * @return DssReqResigTermHeaderView1
     */
    public DssReqResigTermHeaderViewImpl getDssReqResigTermHeaderView1() {
        return (DssReqResigTermHeaderViewImpl) findViewObject("DssReqResigTermHeaderView1");
    }

    /**
     * Container's getter for DssReqResigTermLineView1.
     * @return DssReqResigTermLineView1
     */
    public ViewObjectImpl getDssReqResigTermLineView1() {
        return (ViewObjectImpl) findViewObject("DssReqResigTermLineView1");
    }

    /**
     * Container's getter for DssReqResigTermLineView2.
     * @return DssReqResigTermLineView2
     */
    public ViewObjectImpl getDssReqResigTermLineView2() {
        return (ViewObjectImpl) findViewObject("DssReqResigTermLineView2");
    }

    /**
     * Container's getter for RfrtHeaderFkLink1.
     * @return RfrtHeaderFkLink1
     */
    public ViewLinkImpl getRfrtHeaderFkLink1() {
        return (ViewLinkImpl) findViewLink("RfrtHeaderFkLink1");
    }

    public void Apply() {
        if (getDBTransaction().isDirty()) {

            ViewObject vo = this.getDssReqResigTermHeaderView1();

            String ContentType = null;
            try {
                ContentType = vo.getCurrentRow().getAttribute("FileContentType").toString();
            } catch (NullPointerException e) {
                ContentType = "AAA";
            }

            if (vo.getCurrentRow().getAttribute("RequestType").equals("Resignation")) {
                if ("AAA".equals(ContentType)) {
                    FacesMessage Message = new FacesMessage("Please Upload Resignation Letter.", "");
                    Message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.addMessage(null, Message);
                } else {
                    getDBTransaction().commit();
                    FacesMessage Message = new FacesMessage("Record Saved Successfully!", "");
                    Message.setSeverity(FacesMessage.SEVERITY_INFO);
                    FacesContext fc = FacesContext.getCurrentInstance();
                    fc.addMessage(null, Message);
                }
            } else {
                getDBTransaction().commit();
                FacesMessage Message = new FacesMessage("Record Saved Successfully!", "");
                Message.setSeverity(FacesMessage.SEVERITY_INFO);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, Message);
            }
        }
    }

    public void Rollback() {
        getDBTransaction().rollback();
    }

    public void DeleteCommit() {
        if (getDBTransaction().isDirty()) {
            getDBTransaction().commit();
            FacesMessage Message = new FacesMessage("Record has been deleted Successfully!");
            Message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, Message);
        }
    }

    public void DssApprove() {
        ViewObject vo = this.getDssReqResigTermHeaderView1();
        vo.getCurrentRow().setAttribute("DssStatus", "APPROVED");
        getDBTransaction().commit();
    }

    public void callWorkflow(Number p_document_id, String ApprovalType) {
        NUMBER vNotifId;
        Number p_wf_notif_id = null, p_wf_setup_id = null, p_form_id = null, p_from_user_id = null;
        String p_notification_message = "Approval Required for Resignation / Termination.", p_status = null;

        ViewObject WfVO = this.getWfSetupDetailVO1();
        WfVO.setWhereClause("WORKFLOW_TYPE='" + ApprovalType + "'");
        WfVO.executeQuery();
        if (WfVO.getRowCount() == 0) {
            throw new JboException("Workflow Hierarchy does not exists.");
        } else if (WfVO.getRowCount() > 1) {
            throw new JboException("Multiple Workflow Hierarchy exists.");
        } else if (WfVO.getRowCount() == 1) {
            p_wf_setup_id = (Number) WfVO.first().getAttribute(0);
            p_form_id = (Number) WfVO.first().getAttribute(1);

            ViewObject vo = this.getDssReqResigTermHeaderView1();
            if (vo.getRowCount() == 0) {
                throw new JboException("Please select Agent For Visiting Card Request.");
            } else if (vo.getRowCount() > 0) {
                ViewObject FU = this.getFromUserVO1();
                FU.setWhereClause("USER_ID_PK = " + vo.first().getAttribute("UserIdFk"));
                System.out.println(FU.getQuery());
                FU.executeQuery();
                if (FU.getRowCount() == 1) {
                    p_from_user_id = (Number) vo.first().getAttribute("UserIdFk");
                } else if (FU.getRowCount() == 0) {
                    throw new JboException("Manager does not exists.");
                } else if (FU.getRowCount() > 1) {
                    throw new JboException("Multiple Manager exists.");
                }
            }

            DBTransaction txn = getDBTransaction();
            OracleCallableStatement callableStatement = null;
            if ("BRANCH".equalsIgnoreCase(ApprovalType))
                callableStatement =
                    (OracleCallableStatement) txn.createCallableStatement("BEGIN DSS_SWF_PKG.CALL_WORKFLOW(:1, :2, :3, :4, :5, :6, :7, :8); END;",
                                                                          DBTransaction.DEFAULT);
            else if ("DSS".equalsIgnoreCase(ApprovalType))
                callableStatement =
                    (OracleCallableStatement) txn.createCallableStatement("BEGIN DSS_SWF_PKG.CALL_DSS_WORKFLOW(:1, :2, :3, :4, :5, :6, :7, :8); END;",
                                                                          DBTransaction.DEFAULT);
            try {
                callableStatement.setNUMBER(1, (NUMBER) p_document_id);
                callableStatement.setNUMBER(2, (NUMBER) p_wf_notif_id);
                callableStatement.setNUMBER(3, (NUMBER) p_wf_setup_id);
                callableStatement.setNUMBER(4, p_form_id);
                callableStatement.setNUMBER(5, p_from_user_id);
                callableStatement.setString(6, p_notification_message);
                callableStatement.setString(7, p_status);
                callableStatement.registerOutParameter(8, Types.NUMERIC);

                callableStatement.execute();
                vNotifId = callableStatement.getNUMBER(8);
                callableStatement.close();
                if (vNotifId != null) {
                    if ("BRANCH".equalsIgnoreCase(ApprovalType)) {
                        this.getDssReqResigTermHeaderView1().getCurrentRow().setAttribute("BranchStatus", "INPROCESS");
                        this.getDssReqResigTermHeaderView1().getCurrentRow().setAttribute("BranchNotifIdFk", vNotifId);
                    } else if ("DSS".equalsIgnoreCase(ApprovalType)) {
                        this.getDssReqResigTermHeaderView1().getCurrentRow().setAttribute("DssStatus", "INPROCESS");
                        this.getDssReqResigTermHeaderView1().getCurrentRow().setAttribute("DssNotifIdFk", vNotifId);
                    }
                    getDBTransaction().commit();
                }
            } catch (SQLException e) {
                throw new JboException(e.getMessage());
            }
        }
        this.getDssReqResigTermHeaderView1().executeQuery();
    }

    /**
     * Container's getter for FromUserVO1.
     * @return FromUserVO1
     */
    public ViewObjectImpl getFromUserVO1() {
        return (ViewObjectImpl) findViewObject("FromUserVO1");
    }

    /**
     * Container's getter for WfSetupDetailVO1.
     * @return WfSetupDetailVO1
     */
    public ViewObjectImpl getWfSetupDetailVO1() {
        return (ViewObjectImpl) findViewObject("WfSetupDetailVO1");
    }

    public void callRFRTWorkflow(Number p_document_id) {
        String vStatus = null, vMsg = null;

        DBTransaction txn = getDBTransaction();
        OracleCallableStatement callableStatement = null;

        callableStatement =
            (OracleCallableStatement) txn.createCallableStatement("BEGIN dss_all_pkg.CALL_RFRT_WORKFLOW(:1, :2, :3); END;",
                                                                  DBTransaction.DEFAULT);

        try {
            callableStatement.setNUMBER(1, (NUMBER) p_document_id);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.VARCHAR);

            callableStatement.execute();

            vStatus = callableStatement.getString(2);
            vMsg = callableStatement.getString(3);

            callableStatement.close();
        } catch (SQLException e) {
            try {
                callableStatement.close();
            } catch (SQLException f) {
            }
            throw new JboException(e.getMessage());
        }

        FacesMessage Message = new FacesMessage(vMsg);
        if (vStatus.equalsIgnoreCase("N"))
            Message.setSeverity(FacesMessage.SEVERITY_ERROR);
        else
            Message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, Message);
        txn.rollback();
    }

}
