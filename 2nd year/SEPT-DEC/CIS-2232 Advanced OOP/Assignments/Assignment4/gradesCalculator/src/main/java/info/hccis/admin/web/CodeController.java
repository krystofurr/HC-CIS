//package info.hccis.admin.web;
//
//import info.hccis.admin.dao.CodeValueDAO;
//import info.hccis.admin.model.CodeType;
//import info.hccis.admin.model.CodeValue;
//import info.hccis.admin.model.DatabaseConnection;
//import info.hccis.admin.service.CodeService;
//import java.util.ArrayList;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class CodeController {
//
//    private final CodeService codeService;
//
//    @Autowired
//    public CodeController(CodeService codeService) {
//        this.codeService = codeService;
//    }
//
//    @RequestMapping("/codes/databaseSetup")
//    public String enter(Model model, HttpSession session, DatabaseConnection dbConnectionIn) {
//        System.out.println("Database provided=" + dbConnectionIn.getDatabaseName());
//        model.addAttribute("db", dbConnectionIn);
//        session.setAttribute("db", dbConnectionIn);
//        ArrayList<CodeType> codes = codeService.getCodeTypes(dbConnectionIn);
//        model.addAttribute("codeTypes", codes);
//        return "/codes/codeTypes";
//    }
//
//    @RequestMapping("/codes/codeTypes")
//    public String showCodes(Model model, HttpSession session) {
//
//        DatabaseConnection databaseConnection = (DatabaseConnection) session.getAttribute("db");
//        ArrayList<CodeType> codes = codeService.getCodeTypes(databaseConnection);
//        model.addAttribute("codeTypes", codes);
//        return "/codes/codeTypes";
//    }
//
//    @RequestMapping("/codes/codeValues")
//    public String showCodeValues(Model model, HttpServletRequest request) {
//        String id = request.getParameter("id");
//        System.out.println("id passed in to controller is:" + id);
//        model.addAttribute("codeTypeId", id);
//        //Get the code values 
//        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
//        ArrayList<CodeValue> theList = CodeValueDAO.getCodeValues(dbConnection, id);
//        model.addAttribute("codeValues", theList);
//
//        return "/codes/codeValues";
//    }
//
//    @RequestMapping("/codes/codeValueAdd")
//    public String codeValueAdd(Model model, HttpServletRequest request) {
//        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
//        String id = request.getParameter("id");
//        System.out.println("BJM in codeValueAdd, id passed in to controller is:" + id);
//        CodeValue cv = new CodeValue();
//        cv.setCodeTypeId(Integer.parseInt(id));
//        model.addAttribute("codeValue", cv);
//        return "/codes/codeValueEdit";
//    }
//
//    
//    @RequestMapping("/codes/codeValueEdit")
//    public String codeValueEdit(Model model, HttpServletRequest request) {
//        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
//        String id = request.getParameter("id");
//        String sequence = request.getParameter("sequence");
//        System.out.println("BJM in codeValueEdit, id passed in to controller is:" + id);
//        CodeValue cv = CodeValueDAO.getCodeValue(dbConnection, id, sequence);
//        model.addAttribute("codeValue", cv);
//        return "/codes/codeValueEdit";
//    }
//
//    @RequestMapping("/codes/codeValueEditSubmit")
//    public String codeValueEditSubmit(Model model, HttpServletRequest request, CodeValue codeValue) {
//        System.out.println("Made it to code value edit submit, description=" + codeValue.getDescription());
//        DatabaseConnection dbConnection = (DatabaseConnection) request.getSession().getAttribute("db");
//        CodeValueDAO.addUpdate(dbConnection, codeValue);
//
//        //next send them back to the code values for the code type.
//        ArrayList<CodeValue> theList = CodeValueDAO.getCodeValues(dbConnection, String.valueOf(codeValue.getCodeTypeId()));
//        model.addAttribute("codeValues", theList);
//        
//        model.addAttribute("codeTypeId", codeValue.getCodeTypeId());
//        //send to the codeValues view.
//        return "/codes/codeValues";
//    }
//
//}
