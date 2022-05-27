package sos.haruhi.etl;

public class ETLUtils {

    /**
     * 清洗视频数据
     *
     * 规则:
     * 1. 数据长度必须大于等于9
     * 2. 将视频的类别中的空格去掉
     * 3. 将关联视频通过&拼接

     * @param line
     * @return 如果数据合法，返回清洗完的数据
     *         如果数据不合法， 返回null
     *
     * 测试数据:
     * RX24KLBhwMI	lemonette	697	People & Blogs	512	24149	4.22	315	474	t60tW0WevkE	WZgoejVDZlo	Xa_op4MhSkg	MwynZ8qTwXA	sfG2rtAkAcg	j72VLPwzd_c	24Qfs69Al3U	EGWutOjVx4M	KVkseZR5coU	R6OaRcsfnY4	dGM3k_4cNhE	ai-cSq6APLQ	73M0y-iD9WE	3uKOSjE79YA	9BBu5N0iFBg	7f9zwx52xgA	ncEV0tSC7xM	H-J8Kbx9o68	s8xf4QX1UvA	2cKd9ERh5-8
     */
    public static String etlGulivideoData(String line){
        StringBuffer sbs = new StringBuffer();

        //1. 切割数据
        String[] splits = line.split("\t");
        //2. 规则一
        if(splits.length < 9) {
            return null ;
        }
        //3. 规则二
        splits[3] = splits[3].replaceAll(" ","");

        //4. 规则三
        for (int i = 0; i < splits.length; i++) {
            // 有相关视频 或者 没有相关视频
            if(i <=8){
                if(i == splits.length-1){
                    sbs.append(splits[i]);
                }else{
                    sbs.append(splits[i]).append("\t");
                }
            }else{
                if(i == splits.length-1){
                    sbs.append(splits[i]);
                }else{
                    sbs.append(splits[i]).append("&");
                }
            }
        }

        return sbs.toString() ;

    }

    public static void main(String[] args) {
//        String line = "RX24KLBhwMI\tlemonette\t697\tPeople & Blogs\t512\t24149\t4.22\t315" ;
        String line = "y5kwKp6y8t4\tTheReceptionist\t713\tEntertainment\t204\t2137\t4.61\t70\t64\tPF_ZMlw4rHs&c3XKOAxKc_w&yr73064QrGE&atfNL0_KAcs&kzwa8NBlUeo&qN4YDGysDEI&Z8SMY2jyAYw&sHZwE5GdEdI&xsoIcvgVzbU&CLIEkU0XHO0&aAgZ2Xw6qBc&nWyAgNCHk58&x-fPtq5eQ3o&94yk8QzmA28&c9Ztjs_EXWY&bs-L0XwiHg0&BpbvBwOeCEU&vxBzBimfAYs&5wn4farR4ws&MVcmftKCce8" ;
        String result = etlGulivideoData(line);
        System.out.println(result);
    }
}
