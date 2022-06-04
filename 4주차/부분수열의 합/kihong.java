package edu.test;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer[]> ilist = new ArrayList<Integer[]>();
    static int ea;
    static int num;
    static int[] iarr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        ea = Integer.parseInt(st1.nextToken());
        num = Integer.parseInt(st1.nextToken());
        iarr = new int[st2.countTokens()];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<iarr.length; i++){
            iarr[i]=Integer.parseInt(st2.nextToken());
        }
        makeList(0,stack);
        int sum = 0;
        int cnt = 0;
        //부분수열의 합을 계산 후 같다면 count 증가
        for(int i= 0; i<ilist.size(); i++){
            for(int inum : ilist.get(i)){
                sum+=inum;
            }
            if(sum==num) cnt++;
            sum=0;
        }
        System.out.println(cnt);
    }
    /*
    부분수열을 만드는 함수 (멱함수 만드는 법과 동일)
     */
    public static void makeList(int idx, Stack<Integer> stack) {
        if (idx >= iarr.length) {
            Integer[] arr =  stack.toArray(new Integer[0]);
            if(stack.empty()) return;
            ilist.add(arr);
        } else {
            stack.push(iarr[idx]);
            makeList(idx + 1, stack);
            stack.pop();
            makeList(idx + 1, stack);
        }
    }
}

