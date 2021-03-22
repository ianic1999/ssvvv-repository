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

public class AppTest {

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

    @Test
    public void tc_3_addStudent_valid_group() throws ValidatorException {
        String[] params = {"111", "Student", "1", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test
    public void tc_4_addStudent_valid_id() throws ValidatorException {
        String[] params = {"111", "Student", "1", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_5_addStudent_invalid_id() throws ValidatorException {
        String[] params = {"", "Student", "1", "student@gmail.com", "professor"};
        stsrv.add(params);
    }


    @Test
    public void tc_6_addStudent_valid_nume() throws ValidatorException {
        String[] params = {"111", "Student", "1", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_7_addStudent_invalid_nume() throws ValidatorException {
        String[] params = {"111", "", "1", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test
    public void tc_8_addStudent_valid_indrumator() throws ValidatorException {
        String[] params = {"111", "Student", "1", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_9_addStudent_invalid_indrumator() throws ValidatorException {
        String[] params = {"111", "Student", "1", "student@gmail.com", ""};
        stsrv.add(params);
    }

    @Test
    public void tc_10_addStudent_valid_email() throws ValidatorException {
        String[] params = {"111", "Student", "1", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_11_addStudent_invalid_email() throws ValidatorException {
        String[] params = {"111", "Student", "1", "", "professor"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_12_addStudent_invalid_email() throws ValidatorException {
        String[] params = {"111", "Student", "1", "asdfas;dlkfj", "professor"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_13_addStudent_invalid_id() throws ValidatorException {
        String[] params = {null, "Student", "1", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_14_addStudent_invalid_nume() throws ValidatorException {
        String[] params = {"111", null, "1", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_15_addStudent_invalid_indrumator() throws ValidatorException {
        String[] params = {"111", "Student", "1", "student@gmail.com", null};
        stsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_16_addStudent_invalid_email() throws ValidatorException {
        String[] params = {"111", "Student", "1", null, "professor"};
        stsrv.add(params);
    }
}
