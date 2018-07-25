package it.mobile.whistle.presentation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.mobile.whistle.common.Utility;
import it.mobile.whistle.domain.Utente;

@RestController
@RequestMapping("/api")
public class RESTUploadController {
	
	
	  /*@CrossOrigin
	  @PostMapping("/upload")
	  public boolean pictureupload(@RequestParam("file") MultipartFile file) {

	    System.out.println(file.getName());
	    System.out.println(file.getOriginalFilename());
	    System.out.println(file.getSize());

	    try {
	      Path downloadedFile = Paths.get(file.getOriginalFilename());
	      Files.deleteIfExists(downloadedFile);

	      Files.copy(file.getInputStream(), downloadedFile);

	      return true;
	    }
	    catch (IOException e) {
	      LoggerFactory.getLogger(this.getClass()).error("picture upload", e);
	      return false;
	    }

	  }*/

	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "..//..//..//..//..//resources//";
    //"C://Users//Edgardo Vittoria//DispMobili
    
   /* @GetMapping("/getimg")
	public File getimg(){
		File file = file.
	}*/
    
    @GetMapping("/")
    public String upload(Model model) {
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {


        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Utente utente = Utility.getUtente();
            //utente.setPhoto(bytes);
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

   
}
