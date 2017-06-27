package com.mvcapp1.controllerpackage;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mvcapp1.services.FileUploadInterface;
import com.mvcapp1.services.Services;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class MyController {
	
	@Autowired
	public FileUploadInterface FUI;
	
	@Autowired
	public Services services;
	ArrayList<UserData> usersList;
	
   public void setServices(Services services) {
		this.services = services;
	}
   @Autowired
   ServletContext context; 

   @RequestMapping(value = "/fileUploadPage", method = RequestMethod.GET)
   public ModelAndView fileUploadPage() {
      FileModel file = new FileModel();
      ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
      return modelAndView;
   }

   @RequestMapping(value="/fileUploadPage", method = RequestMethod.POST)
   public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model) throws IOException {
      if (result.hasErrors()) {
         System.out.println("validation errors");
         return "fileUploadPage";
      } else {            
         System.out.println("Fetching file");
         MultipartFile multipartFile = file.getFile();
         
         String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
         //Now do something with file...
         FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath+file.getFile().getOriginalFilename()));
         String fileName = multipartFile.getOriginalFilename();
         model.addAttribute("fileName", fileName);
         return "success";
      }
   }

   @ExceptionHandler	
public String catchEcxeptions(Exception e,Model model)
{
	   System.out.println("in excpetion  ");
	   e.printStackTrace();
	   model.addAttribute("exceptionMsg", e);
	   return "exceptionHandler";
}
   
@RequestMapping(value = "/hello", method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }
   
@RequestMapping(value = "/adduser", method = RequestMethod.POST)
public String newUser( Model model)
{
return "userform";	
}

   @RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public String newUser(@Valid @ModelAttribute("user") UserData user,
			BindingResult result, Model model) throws Exception
	{
	   if(result.hasErrors())
	   {
		  throw new Exception(result.getAllErrors().toString());
//		   model.addAttribute("exceptionMsg", result.getAllErrors().toString());
//		   return "exceptionHandler";
	   }
	   System.out.println("\n name is : " + user + result + "\n");
	   if(user.getId() <0)
	   {
		   throw new Exception("Id should be greater than 0");
	   }
	   
	  // model.addAttribute("Lname", user.getLastName());
	   usersList = services.addUser(user);
	   model.addAttribute("userList", usersList);
	   
		return "showuser";
	   
	}
   
   
   @RequestMapping(value = "/edituser", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") UserData user,
			BindingResult result, Model model)
	{
	  // System.out.println("\n name is : " + user + result + "\n");
	   
	  // model.addAttribute("Lname", user.getLastName());
	   usersList = services.addUser(user);
	   model.addAttribute("userList", usersList);
	   
		return "showuser";
	   
	}
   
   
   @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.POST)
  	public String editUserDetails(@PathVariable int id, Model model)
  	{
	   UserData temp = services.editUser(id);
	  usersList =  services.updateUser(temp);
	  model.addAttribute("eFname", temp.getFirstName());
	  model.addAttribute("eLname", temp.getLastName());
	  model.addAttribute("eID", temp.getId());
	   
	  return "editUser";
  	//  return services.updateUser(id);
  		
  	   
  	}
   
   @RequestMapping(value = "/jasonview/{id}", method = RequestMethod.POST)
 	public @ResponseBody UserData ViewInJason(@PathVariable int id, Model model)
 	{
	   UserData temp = services.editUser(id);
	 
	  return temp;
 	//  return services.updateUser(id);
 		
 	   
 	}
   
   @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.POST)
 	public String updateUser( @PathVariable int id,Model model)
 	{
	  usersList =  services.delUser(id);
	  model.addAttribute("userList", usersList);
	   
	  return "showuser";
 	//  return services.updateUser(id);
 		
 	   
 	}
   
//   @PostMapping("upload")
//   public String uploadFile(@RequestParam("file") MultipartFile file,Model model) throws Exception {
//	   System.out.println("in upload");
//	   if (!file.isEmpty()) {
//	   byte[] bs;
//	   try {
//	   bs = file.getBytes();
//	   String applicationPath = "/home/amarnath/Codes/codesbackup/uploads/";
//	   // File dir= new File(applicationPath);
//	   long unixTime = System.currentTimeMillis() / 1000L;
//	   String ext=".json";
//
//	   
//	   File saveFile = new File(applicationPath + File.separator + "" + unixTime+ext);
//
//	   BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(saveFile));
//	   bufferedOutputStream.write(bs);
//	   bufferedOutputStream.close();
//
//	   } catch (Exception e) {
//	   // TODO Auto-generated catch block
//	   e.printStackTrace();
//	   }
//	   
//	   String dir = "/home/amarnath/Codes/codesbackup/uploads/";
//	   String temp = "";
//	   File[] filelist = new File(dir).listFiles();
//
//	   for (File f : filelist) {
//	   if (f.isFile()) {
//	   temp = f.getName();
//	   }
//	   }
//
//	   dir = dir + temp;
//	   System.out.println(dir);
//	   // System.out.println("ni");
//
//	   File file2 = new File(dir);
//	//   File convFile = new File( applicationPath + File.separator + "" + unixTime+ext+ file.getOriginalFilename());
//	   
//       List<UserData> users = FUI.readContent(file2);
//       services.upload(users);
//       usersList =  services.showUser();
// 	  model.addAttribute("userList", usersList);
//	   } 
//       return "showuser";
//   }
//	   
   
   @PostMapping("/upload")
   public String uploadFile(@RequestParam("file") MultipartFile file,Model model) throws Exception {
    //   File convFile = new File( "/home/amarnath/Codes/codesbackup/uploads/" + file.getOriginalFilename());
       File convFile = new File( context.getRealPath("") + File.separator + "temp" + File.separator + file.getOriginalFilename());
       
       file.transferTo(convFile);
       
       List<UserData> users = FUI.readContent(convFile);
       services.upload(users);
       usersList =  services.showUser();
 	  model.addAttribute("userList", usersList);
       
       return "showuser";
   }
   
//   @RequestMapping(value = "/jsp/upload", method = RequestMethod.POST)
//   public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//
//   System.out.println("in upload");
//   if (!file.isEmpty()) {
//   byte[] bs;
//   try {
//   bs = file.getBytes();
//   String applicationPath = "C:\\Users\\Nirmit Kumar\\workspace\\SpringMVCJava\\temp";
//   // File dir= new File(applicationPath);
//   long unixTime = System.currentTimeMillis() / 1000L;
//   String ext=".xls";
//
//   File saveFile = new File(applicationPath + File.separator + "" + unixTime+ext);
//
//   BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(saveFile));
//   bufferedOutputStream.write(bs);
//   bufferedOutputStream.close();
//
//   } catch (Exception e) {
//   // TODO Auto-generated catch block
//   e.printStackTrace();
//   }
//
//   List<User> users=new ExcelParser().parse();
//   System.out.println(users);
//
//   service.uploadBulk(users);
//
//
//
//   }


   
   
}