package UI;

import Domain.Nota;
import Domain.Student;
import Domain.TemaLab;
import Exceptions.ValidatorException;
import Repository.XMLFileRepository.NotaXMLRepo;
import Repository.XMLFileRepository.StudentXMLRepo;
import Repository.XMLFileRepository.TemaLabXMLRepo;
import Service.XMLFileService.NotaXMLService;
import Service.XMLFileService.StudentXMLService;
import Service.XMLFileService.TemaLabXMLService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTestIntegrationTopDown {

    @Mock
    StudentXMLRepo studentXMLRepo;

    @Mock
    TemaLabXMLRepo temaLabXMLRepo;

    @Mock
    NotaXMLRepo notaXMLRepo;

    @Before
    public void setup() {
        studentXMLRepo = mock(StudentXMLRepo.class);
        temaLabXMLRepo = mock(TemaLabXMLRepo.class);
        notaXMLRepo = mock(NotaXMLRepo.class);
    }

    @Test
    public void tc_1_addStudent_valid() throws ValidatorException {
        String[] paramsStudent = {"111", "Student", "937", "student@gmail.com", "professor"};
        Student student = new Student("111", "Student", 937, "student@gmail.com", "professor");
        StudentXMLService studentXMLService = new StudentXMLService(studentXMLRepo);
        when(studentXMLRepo.save(student)).thenReturn(student);
        when(studentXMLRepo.findOne("111")).thenReturn(student);
        studentXMLService.add(paramsStudent);
        assertNotNull(studentXMLService.findOne("111"));
    }


    @Test
    public void tc_2_student_assignment_integration() throws ValidatorException {
        String[] paramsStudent = {"111", "Student", "937", "student@gmail.com", "professor"};
        Student student = new Student("111", "Student", 937, "student@gmail.com", "professor");
        StudentXMLService studentXMLService = new StudentXMLService(studentXMLRepo);
        when(studentXMLRepo.save(student)).thenReturn(student);
        when(studentXMLRepo.findOne("111")).thenReturn(student);
        studentXMLService.add(paramsStudent);
        assertNotNull(studentXMLService.findOne("111"));

        String[] paramsAssignment={"1","Homework","2","1"};
        TemaLab temaLab = new TemaLab(1,"Homework",2,1);
        TemaLabXMLService temaLabXMLService = new TemaLabXMLService(temaLabXMLRepo);
        when(temaLabXMLRepo.save(temaLab)).thenReturn(temaLab);
        when(temaLabXMLRepo.findOne(1)).thenReturn(temaLab);
        temaLabXMLService.add(paramsAssignment);
        assertNotNull(temaLabXMLService.findOne(1));
    }

    @Test
    public void tc_3_student_assignment_grade_integration() throws ValidatorException {
        String[] paramsStudent = {"111", "Student", "937", "student@gmail.com", "professor"};
        Student student = new Student("111", "Student", 937, "student@gmail.com", "professor");
        StudentXMLService studentXMLService = new StudentXMLService(studentXMLRepo);
        when(studentXMLRepo.save(student)).thenReturn(student);
        when(studentXMLRepo.findOne("111")).thenReturn(student);
        studentXMLService.add(paramsStudent);
        assertNotNull(studentXMLService.findOne("111"));

        String[] paramsAssignment={"1","Homework","2","1"};
        TemaLab temaLab = new TemaLab(1,"Homework",2,1);
        TemaLabXMLService temaLabXMLService = new TemaLabXMLService(temaLabXMLRepo);
        when(temaLabXMLRepo.save(temaLab)).thenReturn(temaLab);
        when(temaLabXMLRepo.findOne(1)).thenReturn(temaLab);
        temaLabXMLService.add(paramsAssignment);
        assertNotNull(temaLabXMLService.findOne(1));

        String[] paramsGrade = {"1", "111", "1", String.valueOf(5f), String.valueOf(LocalDateTime.now())};
        Nota  nota = new Nota(1, "111", 1, 5f, LocalDateTime.now());
        NotaXMLService notaXMLService = new NotaXMLService(notaXMLRepo);
        when(notaXMLRepo.save(nota)).thenReturn(nota);
        when(notaXMLRepo.findOne(1)).thenReturn(nota);
        notaXMLService.add(paramsGrade);
        assertNotNull(notaXMLService.findOne(1));
    }
}
