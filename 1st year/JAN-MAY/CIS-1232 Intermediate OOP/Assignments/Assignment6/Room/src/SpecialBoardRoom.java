/*
 * ========= CIS 1232 Intermediate Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 27-Mar-2015
 * PURPOSE: 
 */

/**
 *
 * @author krystofurr
 */
public class SpecialBoardRoom extends BoardRoom {

    int numberLazyBoyRecliners;
    boolean coffeeMaker;
    
    public SpecialBoardRoom(int roomNumber) {
        super(roomNumber);
        roomType = Room.RoomTypes.ROOM_SPECIAL_BOARD;
    }
    
}
