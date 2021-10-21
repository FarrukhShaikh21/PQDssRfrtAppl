package pqt.dss.rfrt.view.backing;

import java.io.IOException;
import java.io.OutputStream;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.domain.BlobDomain;

import org.apache.commons.io.IOUtils;

//import org.apache.commons.io.IOUtils;

public class fileDownloadClass {
    public fileDownloadClass() {
    }

    public void downloadFile(FacesContext facesContext, OutputStream outputStream)  {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iteratorbinding = bindings.findIteratorBinding("DssReqResigTermHeaderView1Iterator");
        BlobDomain blob =
            (BlobDomain)iteratorbinding.getCurrentRow().getAttribute("ResignationFile");
        try {
            IOUtils.copy(blob.getInputStream(), outputStream);
            blob.closeInputStream();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
