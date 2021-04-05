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

    @Test(expected = IllegalArgumentException.class)
    public void tc_3_addAssignment_invalid_null() throws IllegalArgumentException, ValidatorException {
        tmrepo.save(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tc_4_addAssignment_id_empty() throws IllegalArgumentException, ValidatorException {
        String[] params={"","Homework","0","1"};
        tmsrv.add(params);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tc_5_addAssignment_saptLim_empty() throws IllegalArgumentException, ValidatorException {
        String[] params={"1","Homework","","1"};
        tmsrv.add(params);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tc_6_addAssignment_saptPred_empty() throws IllegalArgumentException, ValidatorException {
        String[] params={"1","Homework","0",""};
        tmsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_7_addAssignment_descriere_empty() throws IllegalArgumentException, ValidatorException {
        String[] params={"1","","0","1"};
        tmsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_8_addAssignment_descriere_null() throws IllegalArgumentException, ValidatorException {
        String[] params={"1",null,"0","1"};
        tmsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_9_addAssignment_id_invalid() throws IllegalArgumentException, ValidatorException {
        String[] params={"-1","Homework","0","1"};
        tmsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_10_addAssignment_saptLim_invalid_lower() throws IllegalArgumentException, ValidatorException {
        String[] params={"1","Homework","-1","1"};
        tmsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_11_addAssignment_saptLim_invalid_upper() throws IllegalArgumentException, ValidatorException {
        String[] params={"1","Homework","15","1"};
        tmsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_12_addAssignment_saptPred_invalid_lower() throws IllegalArgumentException, ValidatorException {
        String[] params={"1","Homework","1","-1"};
        tmsrv.add(params);
    }

    @Test(expected = ValidatorException.class)
    public void tc_13_addAssignment_saptPred_invalid_upper() throws IllegalArgumentException, ValidatorException {
        String[] params={"1","Homework","1","15"};
        tmsrv.add(params);
    }
}
