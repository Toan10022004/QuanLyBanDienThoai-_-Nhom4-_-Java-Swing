package view;

import Form_View.*;
import DTO.DTO_SanPham_pdf;
import Service.SV_BanHang;
import com.itextpdf.text.BaseColor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FirstPdf_hoaDon {

    SV_BanHang svBanHang = new SV_BanHang();
    private Integer id;//id háo đơn

    private String maNV;
    private Integer maKH;
    private String tenKH;
    private String sdtKH;

//    public String tongTienHang;
//    public String giamGiaKhuyenMai;
    public String tonggthanhtoan;

    private String file;
    private static Font catFont;
    private static Font redFont;
    private static Font subFont;
    private static Font smallBold;
    private static Font italicFont;
    private static Font tblFontNho;
    private static Font tblFontTo;
    private static Font tblFontInDo;

    public FirstPdf_hoaDon(int id, String maNV, Integer maKH, String tenKH, String sdtKH, String tonggthanhtoan) {
        this.id = id;
        this.maNV = maNV;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdtKH = sdtKH;
//        this.tongTienHang = tongTienHang;
//        this.giamGiaKhuyenMai = giamGiaKhuyenMai;
        this.tonggthanhtoan = tonggthanhtoan;
        this.file = "C:/Users/84904/Desktop/HoaDon/HoaDon" + id + ".pdf";
        initializeFonts();
    }

    private static void initializeFonts() {
        try {
            BaseFont baseFont = BaseFont.createFont("D:\\JAVA-Code\\QuanLyBanDienThoai_Nhom4\\arialbd.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            catFont = new Font(baseFont, 25, Font.BOLD);
            redFont = new Font(baseFont, 12, Font.NORMAL, BaseColor.RED);
            subFont = new Font(baseFont, 16, Font.BOLD);
            smallBold = new Font(baseFont, 12, Font.BOLD);
            italicFont = new Font(baseFont, 12, Font.ITALIC);
            tblFontNho = new Font(baseFont, 10, Font.NORMAL);
            tblFontTo = new Font(baseFont, 12, Font.NORMAL);
            tblFontInDo = new Font(baseFont, 10, Font.NORMAL, BaseColor.RED);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            // Set custom page size
            Rectangle pageSize = new Rectangle(600, 900);
            Document document = new Document(pageSize);

            PdfWriter.getInstance(document, new FileOutputStream(this.file));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            document.close();
            openPdf(this.file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addMetaData(Document document) {
        document.addTitle("Hóa đơn");
        document.addSubject("Sử dụng iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Người dùng");
        document.addCreator("Người dùng");
    }

    private void addTitlePage(Document document) throws DocumentException, IOException {
    Paragraph preface = new Paragraph();

    Paragraph title = new Paragraph("Cửa hàng Điện thoại", catFont);
    title.setAlignment(Element.ALIGN_CENTER);
    preface.add(title);

    addEmptyLine(preface, 1);

    Paragraph address = new Paragraph("Địa chỉ: 123 Phú Diễn - Minh Khai - Bắc Từ Liêm - Mỹ Đình - Hà Nội", italicFont);
    address.setAlignment(Element.ALIGN_CENTER);
    preface.add(address);

    Paragraph SDT = new Paragraph("Hotline : 19001900", smallBold);
    SDT.setAlignment(Element.ALIGN_CENTER);
    preface.add(SDT);

    addEmptyLine(preface, 1);

    Paragraph receiptTitle = new Paragraph("PHIẾU THANH TOÁN", redFont);
    receiptTitle.setAlignment(Element.ALIGN_CENTER);
    preface.add(receiptTitle);

    addEmptyLine(preface, 1);

    SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("vi", "VN"));
    String dateStr = sdf.format(new Date());
    preface.add(new Paragraph("Ngày: " + dateStr, italicFont));

    preface.add(new Paragraph("Đơn Hàng: " + id, italicFont));
    preface.add(new Paragraph("Nhân Viên: " + maNV, italicFont));
    preface.add(new Paragraph("Mã Khách Hàng: " + maKH, italicFont));
    preface.add(new Paragraph("Tên Khách Hàng: " + tenKH, italicFont));
    preface.add(new Paragraph("SDT Khách Hàng: " + sdtKH, italicFont));

    addEmptyLine(preface, 1);

    document.add(preface);

    PdfPTable table = new PdfPTable(4);
    table.setWidthPercentage(100); // Thiết lập chiều rộng của bảng so với chiều rộng của trang PDF
    float[] columnWidths = {2f, 1.0f, 0.5f, 1.0f}; // Thiết lập trọng lượng cột
    table.setWidths(columnWidths);

    PdfPCell c1 = new PdfPCell(new Phrase("Tên Sản Phẩm", tblFontTo));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    c1.setFixedHeight(30f); // Đặt chiều cao cố định cho ô
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Màu Sắc", tblFontTo));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    c1.setFixedHeight(30f); // Đặt chiều cao cố định cho ô
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("SL", tblFontTo));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    c1.setFixedHeight(30f); // Đặt chiều cao cố định cho ô
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Giá Bán", tblFontTo));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    c1.setFixedHeight(30f); // Đặt chiều cao cố định cho ô
    table.addCell(c1);

    table.setHeaderRows(1);

    PdfPCell cell;
    List<DTO_SanPham_pdf> listsp = new ArrayList<>();
    listsp = svBanHang.selectPrintfHoaDon(id);

    for (DTO_SanPham_pdf sp : listsp) {
        System.out.println("Data Sản Phẩm theo hóa đơn truyền in pdf : ================" + sp);

        cell = new PdfPCell(new Phrase(sp.getTenSP(), tblFontNho));
        cell.setFixedHeight(25f); // Đặt chiều cao cố định cho ô
        cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Căn giữa theo chiều ngang
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Căn giữa theo chiều dọc
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(sp.getMauSac(), tblFontNho));
        cell.setFixedHeight(25f); // Đặt chiều cao cố định cho ô
        cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Căn giữa theo chiều ngang
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Căn giữa theo chiều dọc
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(String.valueOf(sp.getSoLuong()), tblFontNho));
        cell.setFixedHeight(25f); // Đặt chiều cao cố định cho ô
        cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Căn giữa theo chiều ngang
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Căn giữa theo chiều dọc
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(sp.getGiaBan().toString(), tblFontNho));
        cell.setFixedHeight(25f); // Đặt chiều cao cố định cho ô
        cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Căn giữa theo chiều ngang
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Căn giữa theo chiều dọc
        table.addCell(cell);
    }

    document.add(table);
    Paragraph emptyLine = new Paragraph(" ");
    document.add(emptyLine);

    // Create a table with 2 columns
    PdfPTable summaryTable = new PdfPTable(2);
    summaryTable.setWidthPercentage(100);
    float[] summaryColumnWidths = {3f, 1.5f}; // Adjust column widths as needed
    summaryTable.setWidths(summaryColumnWidths);

    // Add the labels
   PdfPCell labelCell = new PdfPCell(new Phrase("Tổng Thanh toán:", tblFontTo));
labelCell.setBorder(Rectangle.NO_BORDER);
labelCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
summaryTable.addCell(labelCell);

PdfPCell valueCell = new PdfPCell(new Phrase(tonggthanhtoan + " VND", redFont));
valueCell.setBorder(Rectangle.NO_BORDER);
valueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
summaryTable.addCell(valueCell);

document.add(summaryTable);

}


    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private static void openPdf(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                } else {
                    System.out.println("Awt Desktop không được hỗ trợ!");
                }
            } else {
                System.out.println("Tệp không tồn tại!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create and run instance
        FirstPdf_hoaDon pdfhd = new FirstPdf_hoaDon(9, "NV999", 9, "Nguyễn Hà Anh", "0123456789", "999.500.000");
        pdfhd.run();
    }
}
