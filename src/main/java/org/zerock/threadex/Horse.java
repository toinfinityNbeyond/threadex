package org.zerock.threadex;

public class Horse extends Thread {


        private String name; //말의 이름
        private int pos; // 말의 포지션

        @Override
        public void run() {  //gallop을 실행하기 위한 메소드
            this.gallop();
        }

         public Horse(String name) {
            this.name = name;
            this.pos = 0;
        }
        public void gallop() {
            for(int i =0 ; i < 100; i ++) {
                int range = (int)(Math.random() * 10) + 1; //1번부터 시작하려고

                this.pos += range; // this.pos = pos + range

                synchronized (System.out) {
                    int count = this.pos/10;
                    for(int j=0; j < count; j++) {
                        System.out.println(".");
                    }
                    System.out.println(this.name + ":" + this.pos);
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            } //end for
        }



        public static void main(String[] args) {
            Horse h1 = new Horse("aaa");

            h1.start(); // 스레드에 사용시 값을 밀어준다.
        }

    }


