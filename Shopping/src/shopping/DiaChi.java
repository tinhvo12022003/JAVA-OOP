/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;
import java.util.*;
/**
 *
 * @author hp
 */
public class DiaChi {
    
    Scanner scanner = new Scanner(System.in);
    
    private int so_nha;
    private String ten_pho;
    
    protected DiaChi(){
        so_nha = 0;
        ten_pho = new String("");
    }
    
    protected DiaChi(int so_nha, String ten_pho){
        this.so_nha = so_nha;
        this.ten_pho = new String(ten_pho);
    }
    
    protected DiaChi(DiaChi dc){
        this.so_nha = dc.so_nha;
        this.ten_pho = new String(dc.ten_pho);
    }
    
    protected void setSoNha(int so_nha){
        this.so_nha = so_nha;
    }
    
    public int getSoNha(){
        return new DiaChi(this).so_nha;
    }
    
    protected void setTenPho(String ten_pho){
        this.ten_pho = new String(ten_pho);
    }
    
    public String getTenPho(){
        return new String(new DiaChi(this).ten_pho);
    }
    
    public void NhapDC(){
        boolean check = false;
        while(!check){
            try {
                System.out.print("Nhap so nha: ");
                this.setSoNha(scanner.nextInt());
                System.out.print("Nhap dia chi nha: ");
                this.setTenPho(new String(scanner.nextLine()));
                check = true;
            } catch(Exception e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }
    
    @Override
    public String toString(){
        DiaChi dc = new DiaChi(this);
        return "So nha: " + dc.getSoNha() + "\nDia chi: " + dc.getTenPho() + "\n"; 
    }
}
