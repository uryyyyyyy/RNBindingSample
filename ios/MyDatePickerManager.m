#import "MyDatePickerManager.h"

#import "RCTBridge.h"
#import "MyDatePicker.h"

@implementation MyDatePickerManager

RCT_EXPORT_MODULE(MyDatePicker)

- (UIView *)view {
  return [[MyDatePicker alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(date, NSDate)
RCT_EXPORT_VIEW_PROPERTY(onMyChange, RCTBubblingEventBlock)
RCT_CUSTOM_VIEW_PROPERTY(mode, UIDatePickerMode, UIDatePicker){
  NSString *modeStr = json;
  NSLog(@"modeStr: %@", modeStr);
  
  UIDatePickerMode pickerMode;
  if([modeStr isEqualToString:@"time"]){
    pickerMode = UIDatePickerModeTime;
  }else if([modeStr isEqualToString:@"date"]){
    pickerMode = UIDatePickerModeDate;
  }else { //datetime
    pickerMode = UIDatePickerModeDateAndTime;
  }
  view.datePickerMode = pickerMode;
}

@end
