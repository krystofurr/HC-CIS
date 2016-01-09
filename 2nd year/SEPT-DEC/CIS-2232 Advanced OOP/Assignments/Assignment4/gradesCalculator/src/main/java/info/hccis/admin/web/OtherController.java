//package info.hccis.admin.web;
//
//import info.hccis.admin.model.DatabaseConnection;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class OtherController {
//
//    @RequestMapping("/other/futureUse")
//    public String showFutureUse(Model model) {
//        return "other/futureUse";
//    }
//
//    @RequestMapping("/other/about")
//    public String showAbout(Model model) {
//        return "other/about";
//    }
//
//    @RequestMapping("/other/help")
//    public String showHelp(Model model) {
//        return "other/help";
//    }
//
////    @RequestMapping("/")
////    public String showHome(Model model) {
////        System.out.println("in controller for /");
////        //setup the databaseConnection object in the model.  This will be used on the 
////        //view.
////        DatabaseConnection databaseConnection = new DatabaseConnection();
////        model.addAttribute("databaseConnection", databaseConnection);
////        
////        return "other/databaseInformation";
////    }
//
//}
