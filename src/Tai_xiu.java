
import java.util.Random;
import java.util.Scanner;

public class Tai_xiu {
    public static void main(String[] args) {
        double tk = 5000.0;
        Scanner sc = new Scanner(System.in);
        int luachon=1;
        do{
            System.out.println("-------Lựa chọn--------");
            System.out.println("1. Tiếp tục chơi");
            System.out.println("2. Chọn phím bất kì để thoát");
            System.out.print("Lựa chọn của bạn: ");
            luachon = sc.nextInt();
            if(luachon==1){
                System.out.println("*** Bắt đầu chơi ***");
                System.out.println("\nBạn có "+tk+" trong tài khoản!");
                System.out.println("Bạn muốn cược bao nhiêu?");
                double datCuoc = 0;
                do{ 
                    System.out.println("Đặt cược số tiền > 0 và < tài khoản của bạn");
                    System.out.print("Số tiền đặt cược: ");
                    datCuoc = sc.nextDouble();
                }while(datCuoc<=0 || datCuoc>tk); 
                int luaChonTaiXiu = 0;
                do{ 
                    System.out.println("Chọn 1 là TÀI, Chọn 2 là XỈU");
                    System.out.print("Đặt cược: ");
                    luaChonTaiXiu = sc.nextInt();
                }while(luaChonTaiXiu<1 || luaChonTaiXiu>2); 
                
                // Random 
                Random xx1 = new Random();
                Random xx2 = new Random();
                Random xx3 = new Random();
                
                int Giatri1 = xx1.nextInt(5)+1;
                int Giatri2 = xx2.nextInt(5)+1;
                int Giatri3 = xx3.nextInt(5)+1;
                int tong = Giatri1+Giatri2+Giatri3;
                // Processing..
                
                System.out.println(Giatri1+"-"+Giatri2+"-"+Giatri3);
                if(tong==3||tong==18){
                    System.out.println("Tổng: "+tong);
                    System.out.println("*** Nhà cái ăn hết ***");
                    tk-=datCuoc;
                    System.out.println("Bạn còn "+tk+" trong tài khoản");
                    checknek(tk);
                }
                else if(tong>=4&&tong<=10){
                    System.out.println("Tổng: "+tong);
                    if(luaChonTaiXiu==2){
                        System.out.println("Bạn đã thắng cược");
                        tk+=datCuoc;
                    }else{
                        System.out.println("Bạn đã thua cược");
                        tk-=datCuoc;
                    }
                    System.out.println("Bạn còn "+tk+" trong tài khoản");
                    checknek(tk);
                }
                else{
                    System.out.println("Tổng: "+tong);
                    if(luaChonTaiXiu==1){
                        System.out.println("Bạn đã thua cược");
                        tk-=datCuoc;
                    }else{
                        System.out.println("Bạn đã thắng cược");
                        tk+=datCuoc;
                    }
                    System.out.println("Bạn còn "+tk+" trong tài khoản");
                    checknek(tk);
                }
            }
        }while(luachon==1);
    }
    
    public static void checknek(double tk){
        Scanner sc = new Scanner(System.in);
        if(tk<=0) {
                   System.out.println("Bạn đã hết tiền, vui lòng nạp tiền để chơi tiếp");
                   System.out.print("Nhập mã thẻ cào(10 số): ");
                   String mathe = sc.nextLine();
                   if(mathe.equals("0123456789")){
                       tk+=50000;
                       System.out.println("Bạn có "+tk+" trong tài khoản");
                   }
                   else{
                       System.out.println("--- Mã thẻ không tồn tại! ---");
                       checknek(tk);
                   }
        }
    }
}

