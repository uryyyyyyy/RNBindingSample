
import UIKit
import Foundation

class MyDatePickerSwift : UIDatePicker {
  
  var onMyChange:RCTBubblingEventBlock? = nil
  
  override init(frame: CGRect) {
    super.init(frame: frame);
    self.addTarget(self, action: #selector(self.buttonTapped(sender:)), for: UIControlEvents.valueChanged)
    self.frame = frame;
  }
  
  func buttonTapped(sender: MyDatePickerSwift) {
    let time = self.date.timeIntervalSince1970 * 1000.0
    let dict: Dictionary = ["changedDate": time];
    sender.onMyChange?(dict)
  }
  
  required init?(coder aDecoder: NSCoder) {
    fatalError("init(coder:) has not been implemented")
  }
}
