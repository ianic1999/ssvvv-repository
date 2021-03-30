package UI;

import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import org.junit.Test;

public class AppTestWhitebox {

    StudentValidator vs=new StudentValidator();
    TemaLabValidator vt=new TemaLabValidator();
    NotaValidator vn=new NotaValidator();
    StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
    TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
    NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
    StudentXMLService stsrv=new StudentXMLService(strepo);
    TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
    NotaXMLService ntsrv=new NotaXMLService(ntrepo);
    ui ui=new ui(stsrv,tmsrv,ntsrv);

    @Test
    public void tc_1_addAssignment_valid() throws ValidatorException {
        String[] params={"1","Homework","2","1"};
        tmsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_2_addAssignment_invalid_saptLim() throws ValidatorException {
        String[] params={"1","Homework","0","1"};
        tmsrv.add(params);
    }
}
