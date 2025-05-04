package pengeluarandappa.dapp;

import pengeluarandappa.dapp.model.Pengeluaran;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.*;

@Controller
public class PengeluaranController {
    private Map<String, List<Pengeluaran>> dataPengeluaranPerUser = new HashMap<>();

    @GetMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "login";
        }
        return "redirect:/input";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, HttpSession session) {
        session.setAttribute("username", username);
        dataPengeluaranPerUser.putIfAbsent(username, new ArrayList<>());
        return "redirect:/input";
    }

    @GetMapping("/input")
    public String input(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) return "redirect:/";
        model.addAttribute("username", session.getAttribute("username"));
        return "input";
    }

    @PostMapping("/tambah")
    public String tambahPengeluaran(@RequestParam double jumlah,
                                    @RequestParam String keterangan,
                                    HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) return "redirect:/";
        dataPengeluaranPerUser.get(username).add(new Pengeluaran(jumlah, keterangan));
        return "redirect:/riwayat";
    }

    @GetMapping("/riwayat")
    public String riwayat(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) return "redirect:/";
        model.addAttribute("pengeluaranList", dataPengeluaranPerUser.get(username));
        return "riwayat";
    }

    @PostMapping("/hapus")
    public String hapusRiwayat(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            dataPengeluaranPerUser.get(username).clear();
        }
        return "redirect:/riwayat";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
