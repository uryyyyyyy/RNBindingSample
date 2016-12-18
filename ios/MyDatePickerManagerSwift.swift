import Foundation

@objc(MyDatePickerManagerSwift)
class MyDatePickerManagerSwift : RCTViewManager {
  override func view() -> UIView! {
    return MyDatePickerSwift();
  }
}
