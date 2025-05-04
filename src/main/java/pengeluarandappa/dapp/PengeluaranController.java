package pengeluarandappa.dapp;

import pengeluarandappa.dapp.model.Pengeluaran;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PengeluaranController {
    private List<Pengeluaran> daftarPengeluaran = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pengeluaranList", daftarPengeluaran);
        return "index";
    }

    @PostMapping("/tambah")
    public String tambahPengeluaran(@RequestParam double jumlah,
                                    @RequestParam String keterangan) {
        daftarPengeluaran.add(new Pengeluaran(jumlah, keterangan));
        return "redirect:/";
    }
}
