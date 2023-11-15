/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Goods;
import Customer.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hp
 */
public class product {
    private String ten_sp;
    private String ma_sp;
    private int so_luong;
    private int gia_sp;
    private Date ngay_sx;

    public product() {
        this.ten_sp = new String("");
        this.ma_sp = new String("");
        this.so_luong = 0;
        this.gia_sp = 0;
        this.ngay_sx = new Date();
    }
    
    public product(String ten_sp, String ma_sp, int so_luong, int gia_sp, Date date){
        this.ten_sp = new String(ten_sp);
        this.ma_sp = new String(ma_sp);
        this.so_luong = so_luong;
        this.gia_sp = gia_sp;
        this.ngay_sx = new Date(date);
    }
    
    public product(product d){
        this.ten_sp = new String(d.ten_sp);
        this.ma_sp = new String(d.ma_sp);
        this.so_luong = d.so_luong;
        this.gia_sp = d.gia_sp;
        this.ngay_sx = new Date(d.ngay_sx);
    }
    
    public void setTen_SP(String ten_sp){
        this.ten_sp = new String(ten_sp);
    }
    
    public String getTen_sp(){
        return new String(new product(this).ten_sp);
    }
    
    public void setMa_sp(String ma_sp){
        this.ma_sp = new String(ma_sp);
    }
    
    public String getMa_sp(){
        return  new String(new product(this).ma_sp);
    }
    
    public void setSoLuong(int so_luong){
        this.so_luong = so_luong;
    }
    
    public int getSoLuong(){
        return new product(this).so_luong;
    }
    
    public void setGia_sp(int gia_sp){
        this.gia_sp = gia_sp;
    }
    
    public int getGia_sp(){
        return new product(this).gia_sp;
    }
    
    public void setNgay_sx(Date date){
        this.ngay_sx = new Date(date);
    }
            
    public Date getNgay_sx(){
        return new Date(new product(this).ngay_sx);
    }
    
    @Override
    public String toString(){
        return this.getTen_sp() + ":" + this.getMa_sp() + ":" + this.getSoLuong() + ":" + this.getGia_sp() + "\n" + this.ngay_sx;
    }
    
    public ArrayList<product> readFile_products() {
        ArrayList<product> lst_pd = new ArrayList<>();
        String line = new String("");
        try (BufferedReader br = new BufferedReader(new FileReader("E:\\Buoi5B2111903\\products.txt"))) {
            while ((line = br.readLine()) != null) {
                product p = new product();

                p.setMa_sp(line);

                p.setTen_SP(br.readLine());

                p.setGia_sp(Integer.parseInt(br.readLine()));

                String date = new String(br.readLine());
                int ngay = Integer.parseInt(date.split("/")[0]);
                int thang = Integer.parseInt(date.split("/")[1]);
                int nam = Integer.parseInt(date.split("/")[2]);

                Date ngay_sx = new Date();
                if (ngay_sx.hopLe(ngay, thang, nam)) {
                    ngay_sx = new Date(ngay, ngay, nam);
                }

                p.setNgay_sx(ngay_sx);

                p.setSoLuong(Integer.parseInt(br.readLine()));
                lst_pd.add(p);

            }
        } catch (IOException ex) {
            Logger.getLogger(GUI_warehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst_pd;
    }
}
