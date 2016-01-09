//package info.hccis.admin.model.validator;
//
//import info.hccis.admin.model.GradeCalculator;
//import info.hccis.admin.model.jpa.Deliverable;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
///**
// *
// * Specialized class to validate form input for inputGrades.html view
// *
// * I think this is the way to make a custom validator actually.....
// *
//*/
//public class GradeCalculatorValidator implements Validator {
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return GradeCalculator.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        
////        ValidationUtils.rejectIfEmpty(errors, "deliverables", "name.empty");
//        GradeCalculator grades = (GradeCalculator) target;
//        
//        
//        for(int i = 0; i < grades.getDeliverables().size(); ++i) {
//            int grade = Integer.parseInt(grades.getDeliverables().get(i).getStringGrade());
//            
//            if( grade == null )
//        }
//        
//        
//        
//        if (grades.getDeliverables() < 0) {
//            e.rejectValue("age", "negativevalue");
//        } else if (p.getAge() > 110) {
//            e.rejectValue("age", "too.darn.old");
//        }
//        
//    }
//    
//}
