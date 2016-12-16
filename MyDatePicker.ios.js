'use strict';

import React, { Component } from 'react';
import requireNativeComponent from 'requireNativeComponent';
const RCTDatePickerIOS = requireNativeComponent('MyDatePicker');

export default class DatePickerIOS extends React.Component {

  _onChange(event) {
    this.props.onDateChange(new Date(event.nativeEvent.myChangeDateEvent));
  }

  render() {
    return (
      <RCTDatePickerIOS
        style={this.props.style}
        date={this.props.date.getTime()}
        mode={this.props.mode}
        onMyChange={this._onChange.bind(this)}
      />
    );
  }
}