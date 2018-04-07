/**
 * Project Name:lession1
 * File Name:Main.java
 * Package Name:d03.m28
 * Date:2018��3��28������5:47:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d03.m28;

import java.util.List;
import java.util.Scanner;

/**
 * Description: <br/>
 * Date: 2018��3��28�� ����5:47:51 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class Main {

    public static void main(String[] args) {
        QuestionInfoDao bizDao = new QuestionInfoDaoImpl();// ����ת��
        System.out.println("---------------------ԭʼ���ݣ�-----------------------");
        List<QuestionInfo> list = bizDao.getAllInfo();
        for (QuestionInfo ff : list) {
            System.out.println(ff.getQuestionId() + "\t" + ff.getQuestion() + "\t" + ff.getAnswer());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        QuestionInfo info = new QuestionInfo();
        System.out.println("������Ҫ�޸ĵı�ţ�");
        info.setQuestionId(sc.nextInt());
        System.out.println("������Ҫ�޸ĵ����:");
        info.setQuestion(sc.next());
        System.out.println("������Ҫ�޸ĵĴ𰸣�");
        info.setAnswer(sc.next());
        int flag = bizDao.updateInfo(info);
        if (flag > 0) {
            System.out.println("�޸ĳɹ���");
        } else {
            System.out.println("�޸�ʧ�ܣ�");
        }
        // System.out.println("������Ҫɾ���ı��:");
        // int id = sc.nextInt();
        // int flag = bizDao.deleteInfo(id);
        // System.out.println("ɾ���Ľ����" + flag);
        System.out.println("=====================����ǣ�======================");
        List<QuestionInfo> list2 = bizDao.getAllInfo();
        for (QuestionInfo ff : list2) {
            System.out.println(ff.getQuestionId() + "\t" + ff.getQuestion() + "\t" + ff.getAnswer());
        }

    }

}
