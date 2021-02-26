package feb21.demo.nController;
import feb21.demo.Model.User;
import feb21.demo.nRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class homeController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("addNumber")
    public String addUser(User ob) {
        System.out.println(ob);
        userRepository.save(ob);
        return "redirect:/";
    }
    @GetMapping("/")
    public String getNumbers(Model model){
        ArrayList<User> ob = (ArrayList<User>) userRepository.findAll();
        model.addAttribute("num",ob);
        return "add";
    }



}