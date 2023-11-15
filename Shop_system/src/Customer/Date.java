/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author hp
 */
public class Date {

    private int ngay, thang, nam;

    public Date() {
        this.ngay = 1;
        this.thang = 1;
        this.nam = 1900;
    }

    public Date(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public Date(int ngay) {
        this.ngay = ngay;
    }

    Date(int ngay, int thang) {
        this.ngay = ngay;
        this.thang = thang;
    }

    public Date(Date obj) {
        this.ngay = obj.getNgay();
        this.thang = obj.getThang();
        this.nam = obj.getNam();
    }

    public Date(Object obj) {
        if (obj instanceof Date d) {
            this.ngay = d.getNgay();
            this.thang = d.thang;
            this.nam = d.nam;
        }
    }


    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getNgay() {
        return this.ngay;
    }

    public int getThang() {
        return this.thang;
    }

    public int getNam() {
        return this.nam;
    }

    public void hienThi() {
        System.out.println(this.getNgay() + "-" + this.getThang() + "-" + this.getNam());
    }

    public boolean namNhuan(int nam) {
        return (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
    }

    public boolean checkThang(int thang) {
        return thang >= 1 && thang <= 12;
    }

    public int maxThang() {
        return 12;
    }

    public int maxNgay(int thang, int nam) {
        if (namNhuan(nam)) {
            if (checkThang(thang)) {
                switch (thang) {
                    case 1, 3, 5, 7, 8, 10, 12 -> {
                        return 31;
                    }
                    case 4, 6, 9, 11 -> {
                        return 30;
                    }
                    case 2 -> {
                        return 29;
                    }
                }
            }
        } else {
            switch (thang) {
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    return 31;
                }
                case 4, 6, 9, 11 -> {
                    return 30;
                }
                case 2 -> {
                    return 28;
                }
            }
        }
        return 1;
    }

    public boolean hopLe(int ngay, int thang, int nam) {
        if (namNhuan(nam)) {
            if (checkThang(thang)) {
                switch (thang) {
                    case 1, 3, 5, 7, 8, 10, 12 -> {
                        return ngay <= 31 && ngay >= 1;
                    }
                    case 2 -> {
                        return ngay <= 29 && ngay >= 1;
                    }
                    case 4, 6, 9, 11 -> {
                        return ngay <= 30 && ngay >= 1;
                    }

                }
            }
        } else {
            if (checkThang(thang)) {
                switch (thang) {
                    case 1, 3, 5, 7, 8, 10, 12 -> {
                        return ngay <= 31 && ngay >= 1;
                    }
                    case 2 -> {
                        return ngay <= 28 && ngay >= 1;
                    }
                    case 4, 6, 9, 11 -> {
                        return ngay <= 30 && ngay >= 1;
                    }

                }
            }
        }
        return false;
    }

    public Date ngayHomSau() {
        Date newDate = new Date(this);
        if (hopLe(newDate.getNgay(), newDate.getThang(), newDate.getNam())) {
            if (newDate.getNgay() == maxNgay(newDate.getThang(), newDate.getNam())) {
                if (newDate.getThang() == maxThang()) {
                    newDate.setNgay(1);
                    newDate.setThang(1);
                    newDate.setNam(newDate.getNam() + 1);
                } else {
                    newDate.setNgay(1);
                    newDate.setThang(newDate.getThang() + 1);
                }
            } else {
                newDate.setNgay(newDate.getNgay() + 1);
            }
        }
        return newDate;
    }

    public Date congNgay(int n) {
        Date newDate = new Date(this);
        if (hopLe(newDate.getNgay(), newDate.getThang(), newDate.getNam())) {
            while (n > 0) {
                int maxNgay = maxNgay(newDate.getThang(), newDate.getNam());
                if (n >= maxNgay - newDate.getNgay() + 1) {
                    n -= maxNgay - newDate.getNgay() + 1;
                    newDate.setNgay(1);
                    if (newDate.getThang() == maxThang()) {
                        newDate.setThang(1);
                        newDate.setNam(newDate.getNam() + 1);
                    } else {
                        newDate.setThang(newDate.getThang() + 1);
                    }
                } else {
                    newDate.setNgay(newDate.getNgay() + n);
                    n = 0;
                }
            }
        }
        return newDate;
    }
    
    @Override
    public String toString(){
        return this.getNgay() + "/" + this.getThang() + "/" + this.getNam();
    }
}

