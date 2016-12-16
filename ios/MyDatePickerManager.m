#import "MyDatePickerManager.h"

#import "RCTBridge.h"
#import "MyDatePicker.h"

@implementation MyDatePickerManager

RCT_EXPORT_MODULE(MyDatePicker)

- (UIView *)view {
  return [[MyDatePicker alloc] init];
}

- (UIDatePickerMode) myAction:(NSString *)modeStr {
  if([modeStr isEqualToString:@"time"]){
    return UIDatePickerModeTime;
  }else if([modeStr isEqualToString:@"date"]){
    return UIDatePickerModeDate;
  }else { //datetime
    return UIDatePickerModeDateAndTime;
  }
}


RCT_EXPORT_VIEW_PROPERTY(date, NSDate)
RCT_EXPORT_VIEW_PROPERTY(onMyChange, RCTBubblingEventBlock)
RCT_CUSTOM_VIEW_PROPERTY(mode, UIDatePickerMode, UIDatePicker){
  NSString *modeStr = json;
  UIDatePickerMode pickerMode = [self myAction:modeStr];
  view.datePickerMode = pickerMode;
}

@end
