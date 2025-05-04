import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.servlet.http.HttpSession;


@Controller
public class PengeluaranController {

    @ModelAttribute("username")
    public String addUsernameToModel(HttpSession session) {
        return (String) session.getAttribute("username");
    }

    @GetMapping("/input")
    public String input(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) return "redirect:/";
        return "input";
    }
}
