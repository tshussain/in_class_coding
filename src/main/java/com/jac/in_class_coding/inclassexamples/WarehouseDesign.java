// Warehouse problem statement

// You've been hired to create an app to help manage inventory in a warehouse. The employees are split into two teams - the fulfillment team and the stocking team.
//
//        The fullfillment team removes items from the shelves and ships them to customers.  If there is any mistake made, they are not permitted to put the items back on the shelf but must put them on a restocking cart.
//
//        The stocking team unloads items from trucks, inspects them and loads them on the shelves if they pass inspection.  They also inspect any items on the restocking cart and load them on the shelves if they pass inspection.  Any items that fail inspection are discarded to the waste bin and considered as wastage.
//
//        Using their individual tablets, all team members need to keep the central system updated with the latest stock numbers for all types of items, and the stocking team also needs to record the total wastage.  Because of an incident last year where an employee was unfairly blamed for another employee's mistake, management does not want fulfillment team members to have access to adding items on the shelves or waste bin, and similarly do not want stocking team members to have access to removing items from the shelves.  Anyone who sees an item out of place may place it on the restocking cart.
//
//        All team members have a unique id. The software needs to be able to access that id in order to flag each action taken.
//
//        a) Create a set of interfaces that will capture the responsibilities of each type of team member.
//
//        b) Create a set of interfaces that will capture adding an item to and/or removing an item from shelves, waste bin and restocking cart.  Make sure that the operations may only be performed by the appropriate type of team member.


// Design brainstorming
//What are the objects / things involved?
//
//        Warehouse
//        Inventory
//
//        Employees
//        Two types: Fullfillment and Stocking
//        --------
//        Person -> Employee -> Stock
//        -> Fullfillment
//        (something about team members)
//        -> Customer
//
//        Inventory
//
//        Wastage
//        --------
//        Restocking cart
//
//        (id)
//        Trucks
//
//        Central system that has to be updated
//
//        Items
//        multi types?
//        Orders
//        Shelves
//
//        (inspection)
//        -------------------
//        What are the behaviors involved?  Assigned or not (grouped or not).
//
//        shipItemToCustomer
//
//        add/load to shelf
//        remove from shelf
//        put back on shelf  (*maybe add is different than put back)
//
//        restock ->
//        put in restocking cart (assign: all team members)
//        remove from stocking cart (stocking team)
//
//        inpect item  (assign to : stocking team)
//        from truck
//        from restocking cart
//        fail inspection
//        pass inspection
//
//        removing from orders (?)
//        discard to waste
//
//        update central system
//        record total wastage
//        record stock numbers
//
//        unloadFromTruck
//        findOutOfPlaceItem
//
//        One database related to the product.  How many are there, id,
//
//        -----
//
//
//        Shelves
//        hold items
//
//        addItem(Item item, StockingTeamMember teamMember)
//
//        can be removed from
//        capacity available
//        capacity consumed
//        (assign location / shelf #)
//        (two different warehouse)
//
//        Restocking Cart
//        hold items
//        addItem(Item item, WarehouseTeamMember warehouseTeamMember)
//        can be removed from
//        (capacity available)
//        (capacity consumed)
//
//        Wastage
//        hold items
//        can be added to
//        capacity consumed
//
//        Truck
//        hold items
//        can be removed from
//        (? how does this info enter the system)
//
//        Central System
//        add stock
//        subtract stock
//        add wastage
//        (add restock)
//        (subtract restock)
//        (in transit??)
//
//        Orders?
//        Customers?
//        Items?
//
//class Employee
//getEmployeeId()
//
//interface WarehouseTeamMember
//    getUniquewarehouseID()
//        putInRestockingCart()
//
//interface FullfillmentTeamMember extends WarehouseTeamMember
//      removeFromShelf()
//        shipItemToCustomer()
//        update central system - stock number (decrease them)
//
//
//interface StockingTeamMember extends WarehouseTeamMember
//     unloadFromTruck
//             addItemToShelf(Item item)
//        put back on shelf
//
//        inpect item
//        from truck
//        from restocking cart
//        discard to waste
//        update central system
//        record total wastage
//        record stock numbers (add to stock, decrease stock)
//
//        remove from stocking cart
//
//        fail inspection
//        pass inspection
//
//
//
//        Fullfillment Team
//        List<FullfillmentTeamMember>
//
//
//
//----
//        Shelves
//        hold items
//
//        addItem(Item item, StockingTeamMember teamMember)
//        removeItem(Item item, FullfillmentTeamMember member)
//
//        capacity available
//        capacity consumed
//        (assign location / shelf #)
//        (two different warehouse)
//
//        Restocking Cart
//        hold items
//        addItem(Item item, WarehouseTeamMember warehouseTeamMember)
//
//        removeItem(Item item, StockingTeamMember member)
//
//        (capacity available)
//        (capacity consumed)
//
//        Wastage
//        hold items
//
//        addItem(Item item, StockingTeamMember member)
//
//        capacity consumed
//
//        Truck
//        hold items
//        can be removed from
//        (? how does this info enter the system)
//
//        Central System
//        increaseStock(Item item, StockingTeamMember member)
//        decreaseStock(Item item, FullfillmentTeamMember member)
//        addWastage(Item item, StockingTeamMember member)
//
//        (add restock)
//        (subtract restock)
//        (in transit??)
//
//
//
// Potential approaches to implementation
//addItemToShelf(Item item) {
//        shelf.addItem(item, this);
//        central.increaseStock(item, this);
//        }
//
//
//        addItem(Item item, StockingTeamMember teamMember) {
//        myListOfItems.add(item);
//        }
//
//        decreaseStock(Item item, FullfillmentTeamMember member) {
//        decreaseStock_internal(item, member.id);
//        }
//
//        addWastage(Item item, StockingTeamMember member) {
//        decreaseStock_internal(item, member.id);
//        }
//
//
//
//class DoAnythingMember implements FullfillmentTeamMember, StockingTeamMember {
//}
//
//interface Team
//
//class Joe extends Employee implement FullfillmentTeamMember
//

//
//
//
