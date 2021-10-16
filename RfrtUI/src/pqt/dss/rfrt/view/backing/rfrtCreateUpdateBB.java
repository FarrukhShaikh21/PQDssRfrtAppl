package pqt.dss.rfrt.view.backing;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.SQLException;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputComboboxListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichSeparator;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;

import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.domain.BlobDomain;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.myfaces.trinidad.component.UIXGroup;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class rfrtCreateUpdateBB {
    private RichButton b3;
    private RichInputFile if2;
    private RichInputText it12;
    private RichPanelFormLayout pfl4;
    private RichPanelHeader ph4;
    private RichPopup p2;
    private RichButton b1;
    private RichPanelFormLayout pfl2;
    private RichPanelHeader ph2;
    private RichInputText it6;
    private RichInputDate id3;
    private RichInputDate id1;
    private RichInputText it5;
    private RichInputText it2;
    private RichInputText it1;
    private RichPanelFormLayout pfl1;
    private RichPanelHeader ph1;
    private RichPanelGroupLayout pgl2;
    private RichPanelStretchLayout psl2;
    private UploadedFile _file;
    private RichDialog d1;
    private RichPanelHeader ph3;
    private RichToolbar t1;
    private UIXGroup g1;
    private RichButton b4;
    private RichInputComboboxListOfValues iclov1;
    private RichSeparator s1;
    private RichInputText it8;
    private RichPanelLabelAndMessage plam1;
    private RichOutputText ot1;
    private RichInputText it11;
    private RichPanelGroupLayout pgl1;
    private RichPanelLabelAndMessage plam2;
    private RichOutputText ot2;
    private RichInputComboboxListOfValues agentStipend1Id;
    private RichInputComboboxListOfValues requestType1Id;
    private RichPanelFormLayout pfl3;
    private RichInputText it4;
    private RichInputText it9;
    private RichInputText it13;
    private RichInputText it14;
    private RichInputText it15;
    private RichInputText it16;
    private RichInputText it7;
    private RichInputText it10;
    private RichInputListOfValues ilov1;
    private RichButton b2;
    private RichInputText it3;
    private RichInputListOfValues planTransferDocNoId;
    private RichPanelLabelAndMessage plam3;
    private RichOutputText ot3;

    public rfrtCreateUpdateBB() {
    }

    public void setB3(RichButton b3) {
        this.b3 = b3;
    }

    public RichButton getB3() {
        return b3;
    }

    public void setIf2(RichInputFile if2) {
        this.if2 = if2;
    }

    public RichInputFile getIf2() {
        return if2;
    }

    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }

    public RichInputText getIt12() {
        return it12;
    }

    public void setPfl4(RichPanelFormLayout pfl4) {
        this.pfl4 = pfl4;
    }

    public RichPanelFormLayout getPfl4() {
        return pfl4;
    }

    public void setPh4(RichPanelHeader ph4) {
        this.ph4 = ph4;
    }

    public RichPanelHeader getPh4() {
        return ph4;
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }


    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setPh2(RichPanelHeader ph2) {
        this.ph2 = ph2;
    }

    public RichPanelHeader getPh2() {
        return ph2;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }


    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }


    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setPh1(RichPanelHeader ph1) {
        this.ph1 = ph1;
    }

    public RichPanelHeader getPh1() {
        return ph1;
    }


    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPsl2(RichPanelStretchLayout psl2) {
        this.psl2 = psl2;
    }

    public RichPanelStretchLayout getPsl2() {
        return psl2;
    }

    public UploadedFile getFile() {
        return _file;
    }

    public void setFile(UploadedFile file) {
        _file = file;
    }

    public void uploadFileVCE(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            //Get File Object from VC Event
            UploadedFile fileVal = (UploadedFile) vce.getNewValue();

            //Traverse over file list to upload all files
            BindingContext bindingctx = BindingContext.getCurrent();
            BindingContainer bindings = bindingctx.getCurrentBindingsEntry();
            DCBindingContainer bindingsImpl = (DCBindingContainer) bindings;
            DCIteratorBinding iter = bindingsImpl.findIteratorBinding("DssReqResigTermHeaderView1Iterator");

            Row row = iter.getCurrentRow();
            // Upload File into Blob Column
            row.setAttribute("ResignationFile", createBlobDomain(fileVal));

            // File Name
            String fileName = (String) fileVal.getFilename();
            row.setAttribute("ResignationLetter", fileName);

            // File Content/MIME Type
            String fileContentType = (String) fileVal.getContentType();
            row.setAttribute("FileContentType", fileContentType);
            
            RichPopup popup = getP2();
            popup.hide();
        }
    }

    public String uploadAttach() {
        // Add event code here...
        //BindingContainer bindings = (BindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        try {
            //            UploadedFile myfile = (UploadedFile)this.getFile();
            UploadedFile myfile = (UploadedFile) this.getIf2();


            BindingContext bindingctx = BindingContext.getCurrent();
            BindingContainer bindings = bindingctx.getCurrentBindingsEntry();
            DCBindingContainer bindingsImpl = (DCBindingContainer) bindings;
            DCIteratorBinding iter = bindingsImpl.findIteratorBinding("DssReqResigTermHeaderView1Iterator");

            Row row = iter.getCurrentRow();
            // Upload File into Blob Column
            row.setAttribute("ResignationFile", createBlobDomain(myfile));

            // File Name
            String fileName = (String) myfile.getFilename();
            row.setAttribute("ResignationLetter", fileName);

            // File Content/MIME Type
            String fileContentType = (String) myfile.getContentType();
            row.setAttribute("FileContentType", fileContentType);

            //Commit Transaction
            //OperationBinding method = bindings.getOperationBinding("Commit");
            //method.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private BlobDomain createBlobDomain(UploadedFile file) {
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
        try {

            in = file.getInputStream();
            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            byte[] buffer = new byte[8192];
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return blobDomain;
    }


    public void setD1(RichDialog d1) {
        this.d1 = d1;
    }

    public RichDialog getD1() {
        return d1;
    }

    public void setPh3(RichPanelHeader ph3) {
        this.ph3 = ph3;
    }

    public RichPanelHeader getPh3() {
        return ph3;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setB4(RichButton b4) {
        this.b4 = b4;
    }

    public RichButton getB4() {
        return b4;
    }


    public void setIclov1(RichInputComboboxListOfValues iclov1) {
        this.iclov1 = iclov1;
    }

    public RichInputComboboxListOfValues getIclov1() {
        return iclov1;
    }


    public void setS1(RichSeparator s1) {
        this.s1 = s1;
    }

    public RichSeparator getS1() {
        return s1;
    }

    public void setIt8(RichInputText it8) {
        this.it8 = it8;
    }

    public RichInputText getIt8() {
        return it8;
    }

    public void setPlam1(RichPanelLabelAndMessage plam1) {
        this.plam1 = plam1;
    }

    public RichPanelLabelAndMessage getPlam1() {
        return plam1;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }


    public void setIt11(RichInputText it11) {
        this.it11 = it11;
    }

    public RichInputText getIt11() {
        return it11;
    }


    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPlam2(RichPanelLabelAndMessage plam2) {
        this.plam2 = plam2;
    }

    public RichPanelLabelAndMessage getPlam2() {
        return plam2;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }


    public void setAgentStipend1Id(RichInputComboboxListOfValues agentStipend1Id) {
        this.agentStipend1Id = agentStipend1Id;
    }

    public RichInputComboboxListOfValues getAgentStipend1Id() {
        return agentStipend1Id;
    }

    public void setRequestType1Id(RichInputComboboxListOfValues requestType1Id) {
        this.requestType1Id = requestType1Id;
    }

    public RichInputComboboxListOfValues getRequestType1Id() {
        return requestType1Id;
    }


    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setIt9(RichInputText it9) {
        this.it9 = it9;
    }

    public RichInputText getIt9() {
        return it9;
    }

    public void setIt13(RichInputText it13) {
        this.it13 = it13;
    }

    public RichInputText getIt13() {
        return it13;
    }

    public void setIt14(RichInputText it14) {
        this.it14 = it14;
    }

    public RichInputText getIt14() {
        return it14;
    }

    public void setIt15(RichInputText it15) {
        this.it15 = it15;
    }

    public RichInputText getIt15() {
        return it15;
    }

    public void setIt16(RichInputText it16) {
        this.it16 = it16;
    }

    public RichInputText getIt16() {
        return it16;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
    }

    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }

    public RichInputText getIt10() {
        return it10;
    }

    public void setIlov1(RichInputListOfValues ilov1) {
        this.ilov1 = ilov1;
    }

    public RichInputListOfValues getIlov1() {
        return ilov1;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public Object getAttributeValue(String AttrName) {
        BindingContainer bdCont = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding val = (AttributeBinding) bdCont.getControlBinding(AttrName);
        return val.getInputValue();
    }
//    public Object getLovValue(String LovValue){
//        JUCtrlListBinding listBindings = (JUCtrlListBinding) getBindings().get("AgenciesVO2");
//         Object str4 = listBindings.getSelectedValues();
//        System.out.println(listBindings.getSelectedValues());
////        return null;
//    }

//    public String ResigLetterValidation() {
//        
//        JUCtrlListBinding listBindings = (JUCtrlListBinding) getBindings().get("RequestType1");
//         Object str4 = listBindings.getSelectedValues();
//        System.out.println(listBindings.getSelectedValues());
//        
////        Object str = getAttributeValue("RequestType");
//        Object str2 = getAttributeValue("FileContentType");
//        BindingContainer bindings = getBindings();
//        OperationBinding operationBinding = bindings.getOperationBinding("Apply");
//        DCBindingContainer dcBindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
////        DCIteratorBinding HdrVO = (DCIteratorBinding) dcBindings.get("DssReqResigTermHeaderView1Iterator");
//
//        if (str4 == "Resignation") {
//            if(str2 == null ) {
//                FacesMessage msg =
//                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                     "Please Upload Resignation Letter", "");
//                FacesContext.getCurrentInstance().addMessage(null, msg);
//            }
//
//            else {
//                operationBinding.execute();
//            }
//        } else {
//            operationBinding.execute();
//        }
//
//        return null;
//    }


    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichButton getB2() {
        return b2;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setPlanTransferDocNoId(RichInputListOfValues planTransferDocNoId) {
        this.planTransferDocNoId = planTransferDocNoId;
    }

    public RichInputListOfValues getPlanTransferDocNoId() {
        return planTransferDocNoId;
    }


    public void setPlam3(RichPanelLabelAndMessage plam3) {
        this.plam3 = plam3;
    }

    public RichPanelLabelAndMessage getPlam3() {
        return plam3;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }
}
