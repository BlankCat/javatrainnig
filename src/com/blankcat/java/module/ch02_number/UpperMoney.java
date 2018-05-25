package com.blankcat.java.module.ch02_number;

/**
 * @author zjf
 * @Date: 2018/5/25
 * @Desc 小写钱转大写
 */
public class UpperMoney {
    public String upper(String money) throws Exception{
        if(!money.matches("^[1-9]+[0-9]*$|^[1-9]+[0-9]*.[0-9]+$" )){
            throw new Exception("钱数格式错误！");
        }
        String[] part= money.split("\\.");
        StringBuffer integer = new StringBuffer();
        for(int i=0;i<part[0].length();i++){
            char perchar = part[0].charAt(i);
            integer.append(this.upperNumber(perchar));
            integer.append(this.upperNumber(part[0].length()-i-1));
        }

        StringBuffer decimal = new StringBuffer();
        if(part.length>1 && !"00".equals(part[1])){
            int length = part[1].length()>=2?2:part[1].length();
            for(int i=0;i<length;i++){
                char perchar = part[1].charAt(i);
                decimal.append(this.upperNumber(perchar));
                if(i==0)decimal.append('角');
                if(i==1)decimal.append('分');
            }
        }
        String result = integer.toString()+decimal.toString();
        return this.dispose(result);
    }

    private char upperNumber(char number){
        switch(number){
            case '0': return '零';
            case '1': return '壹';
            case '2': return '贰';
            case '3': return '叁';
            case '4': return '肆';
            case '5': return '伍';
            case '6': return '陆';
            case '7': return '柒';
            case '8': return '捌';
            case '9': return '玖';
        }
        return 0;
    }

    private char upperNumber(int index){

        switch(index){
            case 0: return '圆';
            case 1: return '拾';
            case 2: return '佰';
            case 3: return '仟';
            case 4: return '万';
            case 5: return '拾';
            case 6: return '佰';
            case 7: return '仟';
            case 8: return '亿';
            case 9: return '拾';
            case 10: return '佰';
            case 11: return '仟';
        }
        return 0;
    }

    private String dispose(String result){
        result = result.replaceAll("零仟零佰零拾|零仟零佰|零佰零拾|零仟|零佰|零拾", "零")
                .replaceAll("零+", "零").replace("零亿", "亿");
        result = result.matches("^.*亿零万[^零]仟.*$" )?result.replace("零万", "零")
                :result.replace("零万", "万");
        result = result.replace("亿万", "亿").replace("零圆", "圆").replace("零分", "")
                .replaceAll("圆零角零分|圆零角$|圆$" , "圆整");
        return result;
    }

    public static void test(){
        try {
//            Assert.assertEquals(upper("1"), "壹圆整");
//            Assert.assertEquals(upper("10"), "壹拾圆整");
//            Assert.assertEquals(upper("20.7"), "贰拾圆柒角");
//            Assert.assertEquals(upper("10.70"), "壹拾圆柒角");
//            Assert.assertEquals(upper("18.5"), "壹拾捌圆伍角");
//            Assert.assertEquals(upper("200.5"), "贰佰圆伍角");
//            Assert.assertEquals(upper("2000"), "贰仟圆整");
//            Assert.assertEquals(upper("50000"), "伍万圆整");
//            Assert.assertEquals(upper("500000"), "伍拾万圆整");
//            Assert.assertEquals(upper("5000000"), "伍佰万圆整");
//            Assert.assertEquals(upper("50000000"), "伍仟万圆整");
//            Assert.assertEquals(upper("500000000"), "伍亿圆整");
//            Assert.assertEquals(upper("5000000000"), "伍拾亿圆整");
//
//            Assert.assertEquals(upper("5000000001"), "伍拾亿零壹圆整");
//            Assert.assertEquals(upper("5000000021"), "伍拾亿零贰拾壹圆整");
//            Assert.assertEquals(upper("5000000421"), "伍拾亿零肆佰贰拾壹圆整");
//            Assert.assertEquals(upper("5000005421"), "伍拾亿零伍仟肆佰贰拾壹圆整");
//            Assert.assertEquals(upper("5000035421"), "伍拾亿零叁万伍仟肆佰贰拾壹圆整");
//            Assert.assertEquals(upper("5000635421"), "伍拾亿零陆拾叁万伍仟肆佰贰拾壹圆整");
//            Assert.assertEquals(upper("5004635421"), "伍拾亿零肆佰陆拾叁万伍仟肆佰贰拾壹圆整");
//            Assert.assertEquals(upper("5024635421"), "伍拾亿贰仟肆佰陆拾叁万伍仟肆佰贰拾壹圆整");
//            Assert.assertEquals(upper("5224635421"), "伍拾贰亿贰仟肆佰陆拾叁万伍仟肆佰贰拾壹圆整");
//
//            Assert.assertEquals(upper("15224635421"), "壹佰伍拾贰亿贰仟肆佰陆拾叁万伍仟肆佰贰拾壹圆整");
//            Assert.assertEquals(upper("215224635421"), "贰仟壹佰伍拾贰亿贰仟肆佰陆拾叁万伍仟肆佰贰拾壹圆整");
//
//            Assert.assertEquals(upper("500021"), "伍拾万零贰拾壹圆整");
//            Assert.assertEquals(upper("5000821"), "伍佰万零捌佰贰拾壹圆整");
//            Assert.assertEquals(upper("5050006501"), "伍拾亿伍仟万陆仟伍佰零壹圆整");
//            Assert.assertEquals(upper("550300001"), "伍亿伍仟零叁拾万零壹圆整");

            System.out.println(new UpperMoney().upper("550300001.01"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
