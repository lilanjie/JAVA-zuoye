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
            if(Point.getDistance(orign,destination)>1000){
                return new User(orign,destination,departtime) ;
            }

            return new User(orign,destination,departtime);//在这里添加判断距离大小试试
        }

       /* public Boolean isEnoughFar(){
            if(Point.getDistance(this.orign,this.destination)>1000){
                return true;
            }
            return false;
        }*/
}
