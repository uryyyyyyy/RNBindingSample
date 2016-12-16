#import "RCTViewManager.h"
#import "RCTConvert.h"

@interface RCTConvert(UIDatePicker)

+ (UIDatePickerMode)UIDatePickerMode:(id)json;

@end

@interface RCTDatePickerManager : RCTViewManager

@end
