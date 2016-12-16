/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

var DatePickerIOS = require('./MyDatePicker');

var DatePickerExample = React.createClass({
  getDefaultProps: function () {
    return {
      date: new Date(),
    };
  },

  getInitialState: function () {
    return {
      date: this.props.date,
    };
  },

  onDateChange: function (date) {
    console.log(date);
    this.setState({date: date});
  },

  render: function () {
    return (
    <View>
      <DatePickerIOS
        style={{height: 200}}
        date={this.state.date}
        mode="datetime"
        onDateChange={this.onDateChange}
      />
      <Text>
        {this.state.date.toString()}
      </Text>
    </View>
    );
  },
});

AppRegistry.registerComponent('RNBindingSample', () => DatePickerExample);
