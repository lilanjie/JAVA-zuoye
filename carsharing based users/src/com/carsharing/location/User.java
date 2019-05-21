package com.carsharing.location;

    public class User {
        public User( Point orign,Point destination, Integer departtime){
            this.orign = orign;
            this.destination = destination;
            this.departtime = departtime;
        }
        private Point orign;
        private Point destination;
        private Integer departtime;


        public Point getOrign() {
            return orign;
        }

        public void setOrign(Point orign) {
            this.orign = orign;
        }

        public Point getDestination() {
            return destination;
        }

        public void setDestination(Point destination) {
            this.destination = destination;
        }

        public Integer getDeparttime() {
            return departtime;
        }

        public void setDeparttime(Integer departtime) {
            this.departtime = departtime;
        }


        public static User RandomCreate() {
            int departtime =(int) (Math.random()*108);
            Point orign = Point.randomCreate();
            Point destination = Point.randomCreate();
            return new User(orign,destination,departtime);
        }

        public Boolean isEnoughFar(){
            if(Point.getDistance(this.orign,this.destination)>1000){
                return true;
            }
            return false;
        }

       // public void print() {

          //  System.out.println("用户原点是： " + this.getOrign()+"终点是："+this.getDestination()+" 出发时间是："+this.getDeparttime());
//
        //}


       /*
        int usernum = 100;
       for(int n = 0; n < usernum; n++){
            Point usero = User.randomCreate();
            Point userd = User.randomCreate();

        }

        */

}
