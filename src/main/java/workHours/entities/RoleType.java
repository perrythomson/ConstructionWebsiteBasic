package workHours.entities;
//
///**
// * Created by perrythomson on 9/2/16.
// */
//public enum RoleType {
//    ADMIN, EMPLOYEE;
//
//
//
//}
//


public class RoleType{


   public enum RoleT { ADMIN, EMPLOYEE};

    public RoleT roleType;


    public RoleT getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleT roleType) {
        this.roleType = roleType;
    }
}
