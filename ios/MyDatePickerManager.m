#import "MyDatePickerManager.h"

#import "RCTBridge.h"
#import "MyDatePicker.h"

@implementation RCTConvert(UIDatePicker)

RCT_ENUM_CONVERTER(UIDatePickerMode, (@{
                                        @"time": @(UIDatePickerModeTime),
                                        @"date": @(UIDatePickerModeDate),
                                        @"datetime": @(UIDatePickerModeDateAndTime),
                                        }), UIDatePickerModeTime, integerValue)

@end

@implementation RCTDatePickerManager

RCT_EXPORT_MODULE(MyDatePicker)

- (UIView *)view{
  return [[MyDatePicker alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(date, NSDate)
RCT_EXPORT_VIEW_PROPERTY(onMyChange, RCTBubblingEventBlock)
RCT_REMAP_VIEW_PROPERTY(mode, datePickerMode, UIDatePickerMode)

@end
