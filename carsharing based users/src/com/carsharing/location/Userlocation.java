package com.carsharing.location;

    public class Userlocation {
        private Point point;

        public Userlocation(Point point){
            super();
            this.point = point;
        }

        public void setPoint(Point point){
            this.point = point;
        }

        public Point getPoint(){
            return point;
        }

        public static Point randomCreate(){
            int x=(int)(Math.random()*8800);
            int y=(int)(Math.random()*8800);
            return new Point(x,y);
        }

        public void print() {

            System.out.println(this.point);

        }

}
