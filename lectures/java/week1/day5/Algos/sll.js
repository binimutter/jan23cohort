// Why linked if we have arrays?
// Linked lists are dynamic in size which makes inserting and deleting easier.

// Singly Linked Lists -  Each node has 2 parts in this case the value and next

// This is what gets added to our List.  The value you are adding and a temp space for what will possibly come next
class Node {
    constructor(val) {
        this.val =  val
        this.next = null
    }
}

class SinglyLinkedList {
    constructor() {
        this.head = null
        this.tail = null
        this.length = 0
    }
    // This will console.log and return the current size fo the list when called
      size() {
        console.log(this.length)
        return this.length
      }
    // print, add, remove, update
    // push = add to the end of the list
    // pop = removes from the end of the list
    // unshift = adds to the front of the list
    // shift = removes from the front of the list

    // Adding to our list (adds to the next of last node)
    push(val) {
        let newNode = new Node(val)

        if(!this.head) { // if .head has no value
            this.head = newNode // make it new entry
            this.tail = this.head // and make .tail the new head .head starts as null so we are making tail also or remain = to null
        } else {
            this.tail.next = newNode // the .next value of the last node now equals the new val
            this.tail = newNode // and the new node created is now tail and thus it's head is equal to the new val
        }
        this.length++
        return this
    }
    pop() {
        if(!this.head) { // if list is empty
            return undefined
        }
        var current = this.head // var current telling it to be = head (1)
        var newTail = current // var newTail = current (1)
        while(current.next) { // while there is a value in current.next
            newTail = current // change newTail to next(current) value
            current = current.next  // and set current to current.next (meaning)
        }
        this.tail = newTail
        this.tail.next = null
        this.length--
        if(this.length === 0) {
            this.head = null
            this.tail = null
        }
        return current
    }
    // This will insert a Node to the beginning of the list
    unshift(val) {
        var newNode = new Node(val)

        if(!this.head) {
            this.head = newNode
            this.tail = this.head
        }
        else {
            newNode.next = this.head
            this.head = newNode
        }
        this.length++
        return this
    }
        // This will remove the 1st node from the list
    shift() {
        if(!this.head) {
            return undefined
        }
        var current = this.head
        this.head = current.next
        this.length--
        if(this.length === 0) {
            this.tail = null
        }
        return current
    }
}
var wos = new SinglyLinkedList()
wos.size()
wos.push("Jarell")
wos.size()
wos.pop()
wos.size()
wos.pop()
wos.size()
wos.push("Melissa")
wos.unshift("Jarell")
wos.size()


// Say i'm building a wall with legos and my son is grabbing the next lego. the lego in my hand to be used on the wall of legos would be the head, whatever Milo finds would be the next lego. the wall ends when milo can't find anymore for me to continue building, if we are breaking down the wall the last lego added is the first to come off.