package UI;

import Domain.Student;
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

import java.util.Arrays;

public class uiTest {

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
    public void tc_1_addStudent_valid_group() throws ValidatorException {
        String[] params = {"111", "Student", "937", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_2_addStudent_invalid_group() throws ValidatorException {
        String[] params = {"112", "Student", "0", "student@gmail.com", "professor"};
        stsrv.add(params);
    }
}
