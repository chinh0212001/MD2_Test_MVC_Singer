package rikkei.academy.view;

import rikkei.academy.controller.SingerController;
import rikkei.academy.model.Singer;

import java.util.Scanner;

public class SingerView {
    SingerController singerController = new SingerController();
Scanner scanner = new Scanner(System.in);
    public void viewSinger() {

        System.out.println("|STT       AGE      SINGER|");
        for (Singer singer : singerController.showSingerList()) {
            System.out.printf("|%3d %11d %13s|\n", singer.getId(), singer.getAge(), singer.getName());
        }

    }
    public void viewDetailSinger(){
        System.out.println("Nhap id Singer de hien thi: ");
        int idSinger = scanner.nextInt();
        System.out.println(singerController.detail(idSinger));
        System.out.println("Nhap vao back de cho lai menu: ");
        String back = scanner.next();
        if(back.equalsIgnoreCase("back")){
            new Main();
        }

    }
    public void viewCreateSinger(){
        System.out.println("Enter singer name");
        String name = scanner.nextLine();
        System.out.println("Enter singer age");
        int age = Integer.parseInt(scanner.nextLine());
        singerController.addSinger(age, name);
    }
    public void viewEditSinger() {
        System.out.println("Enter singer id");
        int idEdit = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter singer name");
        String nameEdit = scanner.nextLine();
        System.out.println("Enter singer age");
        int ageEdit = Integer.parseInt(scanner.nextLine());
        singerController.editSinger(idEdit, ageEdit, nameEdit);
    }
    public void viewRemoveSinger(){
        System.out.println("Enter singer id");
        int idRemove = Integer.parseInt(scanner.nextLine());
//        singerController.deleteSinger(idRemove);5
        System.out.println("Enter 1 la YES 2 la NO");
        int check = scanner.nextInt();

        switch (check){

            case 1:
                System.out.println("yes");
                singerController.deleteSinger(idRemove);
                break;
            case 2:
                System.out.println("no");

        }
    }



}
