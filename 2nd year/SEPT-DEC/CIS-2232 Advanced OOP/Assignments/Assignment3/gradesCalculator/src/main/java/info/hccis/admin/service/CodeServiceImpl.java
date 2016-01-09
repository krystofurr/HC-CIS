//package info.hccis.admin.service;
//
//import info.hccis.admin.dao.CodeTypeDAO;
//import info.hccis.admin.dao.DeliverableDAO;
//import info.hccis.admin.model.CodeType;
//import info.hccis.admin.model.DatabaseConnection;
//import info.hccis.admin.model.Deliverable;
//import java.util.ArrayList;
//import org.springframework.stereotype.Service;
//
///**
// * Mostly used as a facade for all controllers
// *
// * @author BJ MacLean
// * @since 20151013
// */
//
//@Service
//public class CodeServiceImpl implements CodeService {
//
//
//    public  ArrayList<CodeType> getCodeTypes() {
//        System.out.println("returning code values...from CodeServiceImpl");
//        return CodeTypeDAO.getCodeTypes(null);
//    }
//
//    public  ArrayList<CodeType> getCodeTypes(DatabaseConnection databaseConnection) {
//        System.out.println("returning code values...from CodeServiceImpl");
//        return CodeTypeDAO.getCodeTypes(databaseConnection);
//
//    }
//
//}
