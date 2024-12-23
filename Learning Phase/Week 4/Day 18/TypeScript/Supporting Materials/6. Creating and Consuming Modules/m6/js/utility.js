"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.getValue = getInputValue;
exports.logger = logger;
function getInputValue(elementID) {
    var inputElement = document.getElementById(elementID);
    return inputElement.value;
}
function logger(message) {
    console.log(message);
}
//# sourceMappingURL=utility.js.map