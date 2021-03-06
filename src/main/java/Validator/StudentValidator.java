package Validator;

import Domain.Student;
import Exceptions.ValidatorException;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId() == null || s.getId().equals("")){
            //throw new ValidatorException("Id invalid\n");
            errors+="Id invalid\n";
        }
        if(s.getNume()==null || s.getNume().equals("")){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        }
        if(s.getGrupa()<=0){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }
        if( s.getEmail()==null || s.getEmail().equals("") || !s.getEmail().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        }
        if( s.getIndrumator()==null || s.getIndrumator().equals("")) {
            errors+="Indrumator invalid\n";
        }
        if (errors.length()!=0){
            throw  new ValidatorException(errors);
//            System.out.println("aa");
        }
    }
}
