///*
// * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
// * NAME: Christopher Sigouin
// * DATE: 17-Nov-2015
// * PURPOSE: 
// */
//package info.hccis.admin.web.services;
//
//import info.hccis.admin.service.DeliverableService;
//import info.hccis.admin.service.DeliverableServiceImpl;
//import javax.jws.WebMethod;
//import javax.jws.WebParam;
//import javax.jws.WebService;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * A web service that will accept 'grades' from a client and provide the
// * average back to the client.
// * 
// */
//
//
//@WebService(serviceName = "DeliverableWebService")
////@SOAPBinding()
//public class DeliverableWebService {
//    
//
////    public final DeliverableService deliverableService;
//
////    @Autowired(required=false)
////    public DeliverableWebService(DeliverableService deliverableService) {
////        this.deliverableService = deliverableService;
////    }
//    
//    
//
////    @WebMethod(exclude = true);
////    public void setDeliverableService(DeliverableService deliverableService){
////        this.deliverableService = deliverableService;
////    }
//    
//    @WebMethod(operationName = "hello")
//    public String hello(@WebParam(name = "name") String txt) {
//        return "Hello OMFG!!!!! " + txt + " !";
//    }
//    
////    /**
////     * Returns the number of deliverables found within the database to the calling client
////     * 
////     * @param deliverableService
////     * @return 
////     */
////    @WebMethod(operationName = "getDeliverableCount")
////    public int getDeliverableCount(DeliverableService deliverableService) {
////        return deliverableService.getDeliverableCount();
////    }
//    
//    
//}
