//
//  RCTMyAlert.m
//  RNBindingSample
//
//  Created by 柴田幸輝 on 2016/12/10.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import "RCTMyAlert.h"

#import "RCTAssert.h"
#import "RCTConvert.h"
#import "RCTLog.h"
#import "RCTUtils.h"

@implementation RCTConvert (UIAlertViewStyle)

RCT_ENUM_CONVERTER(RCTMyAlertViewStyle, (@{
                                         @"default": @(RCTMyAlertViewStyleDefault),
                                         @"plain-text": @(RCTMyAlertViewStylePlainTextInput),
                                         }), RCTMyAlertViewStyleDefault, integerValue)

@end

@implementation RCTMyAlert
{
  NSHashTable *_alertControllers;
}

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

- (void)invalidate
{
  for (UIAlertController *alertController in _alertControllers) {
    [alertController.presentingViewController dismissViewControllerAnimated:YES completion:nil];
  }
}

RCT_EXPORT_METHOD(alertWithArgs:(NSDictionary *)args
                  callback:(RCTResponseSenderBlock)callback)
{
  NSString *title = [RCTConvert NSString:args[@"title"]];
  NSString *message = [RCTConvert NSString:args[@"message"]];
  RCTMyAlertViewStyle type = [RCTConvert RCTMyAlertViewStyle:args[@"type"]];
  NSArray<NSDictionary *> *buttons = [RCTConvert NSDictionaryArray:args[@"buttons"]];
  NSString *defaultValue = [RCTConvert NSString:args[@"defaultValue"]];
  NSString *cancelButtonKey = [RCTConvert NSString:args[@"cancelButtonKey"]];
  NSString *destructiveButtonKey = [RCTConvert NSString:args[@"destructiveButtonKey"]];
  
  if (!title && !message) {
    RCTLogError(@"Must specify either an alert title, or message, or both");
    return;
  }
  
  if (buttons.count == 0) {
    if (type == RCTMyAlertViewStyleDefault) {
      buttons = @[@{@"0": RCTUIKitLocalizedString(@"OK")}];
      cancelButtonKey = @"0";
    } else {
      buttons = @[
                  @{@"0": RCTUIKitLocalizedString(@"OK")},
                  @{@"1": RCTUIKitLocalizedString(@"Cancel")},
                  ];
      cancelButtonKey = @"1";
    }
  }
  
  UIViewController *presentingController = RCTPresentedViewController();
  if (presentingController == nil) {
    RCTLogError(@"Tried to display alert view but there is no application window. args: %@", args);
    return;
  }
  
  UIAlertController *alertController = [UIAlertController
                                        alertControllerWithTitle:title
                                        message:nil
                                        preferredStyle:UIAlertControllerStyleAlert];
  switch (type) {
    case RCTMyAlertViewStylePlainTextInput: {
      [alertController addTextFieldWithConfigurationHandler:^(UITextField *textField) {
        textField.secureTextEntry = NO;
        textField.text = defaultValue;
      }];
      break;
    }
    case RCTMyAlertViewStyleDefault:
      break;
  }
  
  alertController.message = message;
  
  for (NSDictionary<NSString *, id> *button in buttons) {
    if (button.count != 1) {
      RCTLogError(@"Button definitions should have exactly one key.");
    }
    NSString *buttonKey = button.allKeys.firstObject;
    NSString *buttonTitle = [RCTConvert NSString:button[buttonKey]];
    UIAlertActionStyle buttonStyle = UIAlertActionStyleDefault;
    if ([buttonKey isEqualToString:cancelButtonKey]) {
      buttonStyle = UIAlertActionStyleCancel;
    } else if ([buttonKey isEqualToString:destructiveButtonKey]) {
      buttonStyle = UIAlertActionStyleDestructive;
    }
    [alertController addAction:[UIAlertAction actionWithTitle:buttonTitle
                                                        style:buttonStyle
                                                      handler:^(__unused UIAlertAction *action) {
                                                        switch (type) {
                                                          case RCTMyAlertViewStylePlainTextInput:
                                                          case RCTMyAlertViewStyleDefault:
                                                            callback(@[buttonKey]);
                                                            break;
                                                        }
                                                      }]];
  }
  
  if (!_alertControllers) {
    _alertControllers = [NSHashTable weakObjectsHashTable];
  }
  [_alertControllers addObject:alertController];
  
  [presentingController presentViewController:alertController animated:YES completion:nil];
}

@end
