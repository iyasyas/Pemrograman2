import java.awt.FlowLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class CetakLaporanForm extends JFrame {

    public CetakLaporanForm() {
        setTitle("Cetak Laporan Mahasiswa");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JButton btnCetak = new JButton("Cetak Laporan");

        btnCetak.addActionListener(e -> {
            cetakLaporan();
        });

        setLayout(new FlowLayout());
        add(btnCetak);
    }

    private Connection getKoneksi() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/mhs";
        String user = "root";
        String password = "";

        return DriverManager.getConnection(url, user, password);
    }

    private void cetakLaporan() {

        try (
            Connection conn = getKoneksi();
            InputStream is = getClass().getResourceAsStream("/LaporanMahasiswa.jrxml")
        ) {

            if (is == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "File LaporanMahasiswa.jrxml tidak ditemukan!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            JasperReport report = JasperCompileManager.compileReport(is);

            Map<String, Object> params = new HashMap<>();
            params.put("judul", "Laporan Data Mahasiswa");

            JasperPrint print = JasperFillManager.fillReport(
                    report,
                    params,
                    conn
            );

            JasperViewer.viewReport(print, false);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Gagal cetak laporan: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {
            new CetakLaporanForm().setVisible(true);
        });

    }
}