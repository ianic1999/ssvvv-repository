package UI;

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

import java.time.LocalDateTime;

public class AppTestIntegration {

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
    public void tc_1_addStudent_valid() throws ValidatorException {
        String[] params = {"111", "Student", "937", "student@gmail.com", "professor"};
        stsrv.add(params);
    }

    @Test
    public void tc_2_addAssignment_valid() throws ValidatorException {
        String[] params={"1","Homework","2","1"};
        tmsrv.add(params);
    }

    @Test
    public void tc_3_addGrade_valid() throws ValidatorException {
        String[] params = {"1", "111", "1", String.valueOf(5f), String.valueOf(LocalDateTime.now())};
        ntsrv.add(params);
    }

    @Test
    public void tc_4_integration() throws ValidatorException {
        String[] paramsStudent = {"111", "Student", "937", "student@gmail.com", "professor"};
        stsrv.add(paramsStudent);

        String[] paramsAssignment={"1","Homework","2","1"};
        tmsrv.add(paramsAssignment);

        String[] paramsGrade = {"1", "111", "1", String.valueOf(5f), String.valueOf(LocalDateTime.now())};
        ntsrv.add(paramsGrade);
    }
}
