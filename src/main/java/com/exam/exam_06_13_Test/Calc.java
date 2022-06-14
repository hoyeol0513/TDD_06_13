package com.exam.exam_06_13_Test;

public class Calc {
    public int calc(String s) {
        //마이너스 진행 예정 (06.14)
        
        s = stripOutterBracket(s); //바깥 괄호 제거
        int operatorNum = getOperator(s); // +,-,*,/ 에 대한 숫자 세기
        int splitIndex = 0; // +,-,*,/ 를 분리점으로 삼는 인덱스
        int bracketNum = getBracket(s); //바깥괄호를 제외한 괄호의 개수 (괄호 연산할 때)

        //괄호 있는 복합 연산 : 괄호를 찾아서 해당 것을 따로 계산하고 S에 붙이기
        if (bracketNum > 0) {

            String bracketStr = null; //괄호 안의 연산만 담는 String
            int splitHeadIndex = 0; // 괄호의 시작 인덱스
            int splitTailIndex = 0; // 괄호의 끝 인덱스
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') splitHeadIndex = i; //처음 나오는 여는 괄호의 인덱스를 저장
                if (s.charAt(i) == ')') splitTailIndex = i; //처음 나오는 닫는 괄호의 인덱스를 저장
            }
            bracketStr = s.substring(splitHeadIndex + 1, splitTailIndex).trim(); //괄호 안의 연산만 따로 substring (떼어내기)
            String afterBracket = s.substring(splitTailIndex + 1, s.length()); //해당 괄호의 앞에 있는 문자열
            String beforeBracket = s.substring(0, splitHeadIndex); //해당 괄호의 뒤에 있는 문자열
            //앞 뒤를 계산하지 말고 그냥 괄호를 계산한 값에 앞뒤를 더하면 되지않나?..
            s = beforeBracket + calc(bracketStr) + afterBracket; //괄호의 앞,뒤와 괄호 안 계산을 붙이기
            //null값이면 없을 것이니깐 ㄱㅊ (ex. 5 * (3 + 2) )
            return calc(s);  //다시 재정의한 s를 재귀함수로 다시
        }

        if(operatorNum == 0){ //연산자 없는 숫자
            return Integer.parseInt(s); //연산자가 없어서 그냥 정수화해서 계산.
        }else if(operatorNum == 1){ //연산자가 하나 있는 단순 연산
            return simpleCalc(s); //1+1과 같은 단순연산을 하여 계산.
        }else { //복합연산(괄호 x)
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+' || s.charAt(i) == '-') { //s 문자열 전체를 돌면서 +와 - 인덱스 찾기
                    splitIndex = i;
                }
                if(splitIndex == 0) { // 문자열 s에 +/- 가 없는 경우 (*, / 로만 이루어져 있음.)
                    if (s.charAt(i) == '*' || s.charAt(i) == '/') splitIndex = i; //*, /의 인덱스를 저장
                }
            }
        }
        String head = s.substring(0,splitIndex - 1).trim(); //연산자의 인덱스를 기점으로 앞부분
        String tail = s.substring(splitIndex + 1,s.length()).trim(); //연산자의 인덱스를 기점으로 뒷부분
        if(s.charAt(splitIndex) == '+'){ //자른 head 와 tail을 + 연산
            return calc(head) + calc(tail);
        }
        else if(s.charAt(splitIndex) == '-'){ //자른 head 와 tail을 - 연산
            return calc(head) - calc(tail);
        }
        else if(s.charAt(splitIndex) == '*'){ //자른 head 와 tail을 * 연산
            return calc(head) * calc(tail);
        }
        return calc(head) / calc(tail); //자른 head 와 tail을 / 연산
    }

    private int getBracket(String s) {
        int cnt = 0;
        for(int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                cnt++;
            }
        }
        return cnt;
    }

    private int simpleCalc(String s) {
        //단순연산 정리하기
        if(s.indexOf('-') != -1){
            return minus(s);
        }
        if(s.indexOf('*') != -1){
            return multi(s);
        }
        if(s.indexOf('/') != -1){
            return divide(s);
        }
        return plus(s);
    }

    private int getOperator(String s) {
        int operatorNum = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                operatorNum++;
            }
        }
        return operatorNum;
    }

    private String stripOutterBracket(String s) {
        //괄호 벗기기 (괄호 벗기면 단순연산)
        //바깥 괄호를 다 벗길 때까지 반복
        while(s.charAt(0) == '(' && s.charAt(s.length()-1) == ')'){
            s = s.substring(1,s.length()-1);
        }
        return s;
    }

    private int divide(String s) {
        String[] sBits = s.split(" \\/ ");
        int n1 = Integer.parseInt(sBits[0]);
        int n2 = Integer.parseInt(sBits[1]);
        return n1 / n2;
    }

    private int multi(String s) {
        String[] sBits = s.split(" \\* ");
        int n1 = Integer.parseInt(sBits[0]);
        int n2 = Integer.parseInt(sBits[1]);
        return n1 * n2;
    }
    private int minus(String s) {
        String[] sBits = s.split(" \\- ");
        int n1 = Integer.parseInt(sBits[0]);
        int n2 = Integer.parseInt(sBits[1]);
        return n1 - n2;
    }
    private int plus(String s) {
        String[] sBits = s.split(" \\+ ");
        int n1 = Integer.parseInt(sBits[0]);
        int n2 = Integer.parseInt(sBits[1]);
        return n1 + n2;
    }
}