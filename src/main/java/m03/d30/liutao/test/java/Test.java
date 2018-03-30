/**
 * Project Name:study
 * File Name:Test.java
 * Package Name:com.test.java
 * Date:2018��3��28������5:31:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.java;

import java.util.List;
import java.util.Scanner;

import com.test.dao.QuestionInfoDao;
import com.test.dao.impl.QuestionInfoDaoImpl;
import com.test.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018��3��28�� ����5:31:14 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        // while (true) {
        QuestionInfoDao qi = new QuestionInfoDaoImpl();// ����ת��
        Scanner sca = new Scanner(System.in);
        boolean cc = true;
        while (cc) {

            System.out.println("******************************��ӭʹ���������ϵͳ*********************************");
            System.out.print("��ѡ�����(1.�г��������� 2.����Ŀ��ѯ 3.�����ģ����ѯ 4.������� 5.ɾ������ 6.�˳�ϵͳ):");
            int num = sca.nextInt();
            switch (num) {
            case 1:// ��ѯ����
                   // List<QuestionInfo> list = qi.getAllQuery();
                List<QuestionInfo> list = qi.callprodedure();// �������̲�ѯ����
                for (QuestionInfo questionInfo : list) {
                    System.out.println(questionInfo.getQuestionId() + "��" + questionInfo.getQuestion() + "\n\t"
                            + "ѡ��A:" + questionInfo.getOptionA() + "\n\t" + "ѡ��B:" + questionInfo.getOptionB() + "\n\t"
                            + "ѡ��C:" + questionInfo.getOptionC() + "\n\t" + "ѡ��D:" + questionInfo.getOptionD() + "\n\t"
                            + "��:" + questionInfo.getAnswer());
                }

                break;
            case 2:// ����Ŀ��ѯ
                System.out.print("�������Ŀ:(1.Java 2.C# 3.JSP):");
                int num1 = sca.nextInt();
                List<QuestionInfo> list1 = qi.getsubject(num1);
                for (QuestionInfo questionInfo : list1) {
                    System.out.println(questionInfo.getQuestionId() + "��" + questionInfo.getQuestion() + "\n\t"
                            + "ѡ��A:" + questionInfo.getOptionA() + "\n\t" + "ѡ��B:" + questionInfo.getOptionB() + "\n\t"
                            + "ѡ��C:" + questionInfo.getOptionC() + "\n\t" + "ѡ��D:" + questionInfo.getOptionD() + "\n\t"
                            + "��:" + questionInfo.getAnswer());
                }
                break;
            case 3:// ���ģ����ѯ
                System.out.print("���������:");
                String st = sca.next();
                // List<QuestionInfo> list2 = qi.getLike(st);
                List<QuestionInfo> list2 = qi.callprocedure2(st);// �������̣�ģ����ѯ
                for (QuestionInfo questionInfo : list2) {
                    System.out.println(questionInfo.getQuestionId() + "��" + questionInfo.getQuestion() + "\n\t"
                            + "ѡ��A:" + questionInfo.getOptionA() + "\n\t" + "ѡ��B:" + questionInfo.getOptionB() + "\n\t"
                            + "ѡ��C:" + questionInfo.getOptionC() + "\n\t" + "ѡ��D:" + questionInfo.getOptionD() + "\n\t"
                            + "��:" + questionInfo.getAnswer());
                }
                break;
            case 4:// �����Ŀ
                QuestionInfo qq = new QuestionInfo();
                System.out.print("�������Ŀ:(1.Java 2.C# 3.JSP):");
                int num2 = sca.nextInt();
                qq.setSubject(num2);
                System.out.print("�������µ����:");
                String str = sca.next();
                qq.setQuestion(str);
                System.out.print("�������µ�ѡ��A:");
                String str1 = sca.next();
                qq.setOptionA(str1);
                System.out.print("�������µ�ѡ��B:");
                String str2 = sca.next();
                qq.setOptionB(str2);
                System.out.print("�������µ�ѡ��C:");
                String str3 = sca.next();
                qq.setOptionC(str3);
                System.out.print("�������µ�ѡ��D:");
                String str4 = sca.next();
                qq.setOptionD(str4);
                System.out.print("�������µĴ�:");
                String str5 = sca.next();
                qq.setAnswer(str5);
                int flag = qi.uppdata(qq);
                if (flag > 0) {
                    System.out.println("��ӳɹ���");

                } else {
                    System.out.println("���ʧ�ܣ�");

                }

                break;
            case 5:// ɾ������
                boolean tt = true;
                while (tt) {
                    System.out.print("������Ҫɾ����������:");
                    int questionId = sca.nextInt();
                    int flag1 = qi.delete(questionId);
                    if (flag1 > 0) {
                        System.out.println("ɾ���ɹ���");
                        tt = false;

                    } else {
                        System.out.println("�Բ���,û��Ҫɾ���ı��!,����������");
                    }
                }
                break;
            case 6:// �˳�����
                System.out.println("�ɹ��˳�!");
                cc = false;
            default:
                System.out.println("������������������(1-6)");
            }
        }
        sca.close();
        // }
    }
}
