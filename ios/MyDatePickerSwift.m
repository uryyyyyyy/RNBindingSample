#import "RCTViewManager.h"

@interface RCT_EXTERN_MODULE(MyDatePickerManagerSwift, RCTViewManager)
RCT_EXPORT_VIEW_PROPERTY(date, NSDate)
RCT_EXPORT_VIEW_PROPERTY(onMyChange, RCTBubblingEventBlock)
RCT_CUSTOM_VIEW_PROPERTY(mode, UIDatePickerMode, UIDatePicker){
  NSString *modeStr = json;
  UIDatePickerMode pickerMode = [self myAction:modeStr];
  view.datePickerMode = pickerMode;
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

@end
