
import Foundation
import MediaPlayer

@objc(MyLogSwift)
class MyLogSwift: NSObject {

  @objc(callFunc:dict:findEvents:)
  func callFunc(typeParam: NSInteger, dict: NSDictionary, callback: RCTResponseSenderBlock) {
    
    let num = (typeParam as Int)
    var enumVal = ""
    switch num {
      case 1: enumVal = "pattern 1"
      case 2: enumVal = "pattern 2"
      case _: enumVal = "bad pattern"
    }
    print("typeParam: " + enumVal);
    
    let _dict:Dictionary = dict as Dictionary
    print("dict: ");
    print(_dict)

    let obj: Dictionary<String, String> = ["foo": "bar", "hey": "ho"]

    callback([NSNull(), obj]);
  }

}
